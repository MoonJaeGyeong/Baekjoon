import java.util.*;
import java.io.*;

/**
 * 
 * @author SSAFY
 *1. N : 역의 개수 입력
 *2. List<>[N] subway 지하철 노드 간 양방향 연결
 *3. visited[N] 와 visitedCnt[N] 을 이용하여 visited 한 곳을 다시 방문 시 +1 
 *	3-1. visitedCnt[i] 가 >= 3 이 되었을 때 
 *	3-2. 현재까지 기록한 route idx를 모두 cycles[] true 로 변경
 *4. 각 노드에서 시작하여 다음 idx 가 cycles[] true 가 나올 때 까지 탐색 하다 나왔을 때 탐색 종료
 *	4-1. 이를 answer[idx] 에 기록
 *5. answer 출력
 * 
 */

class Main{
	
	static int N; // 역의 개수
	static List<Integer>[] subway;
	static boolean[] visited;
	static int[] visitedCnt;
	static boolean[] isCycle;
	static int[] answer;
	
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	
	static void init() {
		N = sc.nextInt();
		subway = new ArrayList[N+1];
		visited = new boolean[N+1];
		visitedCnt = new int[N+1];
		isCycle = new boolean[N+1];
		answer = new int[N+1];
		
		for(int idx=1; idx<=N; idx++) {
			subway[idx] = new ArrayList<>();
			answer[idx] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			subway[start].add(end);
			subway[end].add(start);
		}
	}
	
	public static void main(String[] args) {
		init();
		
		visited[1] = true;
		visitedCnt[1]++;
		checkCycle(1, new int[] {1});

		for(int idx=1; idx<=N; idx++) {
			getDistanceFromCycle(idx);
		}
		
		for(int idx=1; idx<=N; idx++) {
			sb.append(answer[idx]).append(" ");
		}
		
		System.out.println(sb);

	}
	
	public static void checkCycle(int curIdx, int[] route) {

		for(int nextIdx : subway[curIdx]) {
			if(visited[nextIdx]) { // 방문한 곳이면		
				visitedCnt[nextIdx]++;
				contains(route, nextIdx);
				continue;
			}
			
			visited[nextIdx] = true;
			visitedCnt[nextIdx]++;
			int[] newRoute = new int[route.length + 1];
			for(int idx=0; idx<route.length; idx++) {
				newRoute[idx] = route[idx];
			}
			newRoute[route.length] = nextIdx; 
			checkCycle(nextIdx, newRoute);
		}
				
	}
	
	public static void contains(int[] route, int nextIdx) {
		if(route.length < 2) return;
		if(route[route.length - 2] == nextIdx) return;
		
		
		
		for(int idx=0; idx<route.length; idx++) {
			if(route[idx] == nextIdx) {
				fillCycle(Arrays.copyOfRange(route, idx, route.length));
				return;
			}
		}
	}
	
	public static void getDistanceFromCycle(int idx) {
		if(isCycle[idx]) {
			answer[idx] = 0;
			return;
		}
		
		visited = new boolean[N+1]; // 다시 쓸 거라 초기화
		Deque<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {idx, 0});
		visited[idx] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curIdx = cur[0];
			int curDistance = cur[1];
			
			
			for(int nextIdx : subway[curIdx]) {
				if(visited[nextIdx]) continue;
				
				if(isCycle[nextIdx]) {
					answer[idx] = curDistance+1;
					return;
				}
				
				visited[nextIdx] = true;
				queue.add(new int[] {nextIdx, curDistance + 1});
			}
		}
		
	}
	
	public static void fillCycle(int[] route) {
		for(int idx=0; idx<route.length; idx++) {
			isCycle[route[idx]] = true;
		}
	}
	
}
