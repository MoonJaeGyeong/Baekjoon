
import java.io.*;
import java.util.*;

/**
 * 
 * @author SSAFY
 * 1. a : 출발 Index 와  b : 도착 Index 를 입력 받음
 * 2. N(1 < =N <= 1000) : 전체 문자의 수 와  M(1 <= M <= 10000) : 치환 가능한 문자의 수를 입력 받음 
 * 3. 배열 arr[N+1][N+1] 생성, distance[N+1] 생성
 * 4. M번 만큼 반복하며 arr 배열 채워주기
 * 5. arr[a][idx] N번 만큼 반복하며 distance 배열 채우기 
 * 6. 배열을 순회하며 갱신
 * 	6-1. distance 가 가장 짧은 Index 추출
 * 	6-2. 가장 짧은 Index 기준 1~N 까지 다음으로 가는 반복문 생성
 * 	6-3. distance[nextIndex] > arr[minIndex][nextIndex] + distance[minIndex] 라면 distance 갱신  
 * 7. 이를 반복하여 모든 거리 갱신
 * 8. distance[b] 출력 
 *
 */

public class Main {
	
	static int startIdx;
	static int endIdx;
	static int numOfNumber;
	static int routeCount;
	static int[][] route;
	static int[] distance;
	static boolean[] visited;
	
	static final int MAX = 99999;
	
	public static void main(String[] args) throws IOException {
		// 1. a : 출발 Index 와  b : 도착 Index 를 입력 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		startIdx = Integer.parseInt(st.nextToken());
		endIdx = Integer.parseInt(st.nextToken());
		
		// N(1 < =N <= 1000) : 전체 문자의 수 와  M(1 <= M <= 10000) : 치환 가능한 문자의 수를 입력 받음 
		st = new StringTokenizer(br.readLine());
		numOfNumber = Integer.parseInt(st.nextToken());
		routeCount = Integer.parseInt(st.nextToken());
		
		route = new int[numOfNumber+1][numOfNumber+1];
		distance = new int[numOfNumber+1];
		visited = new boolean[numOfNumber+1];
		
		for(int rows=1; rows<=numOfNumber; rows++) {
			for(int cols=1; cols<=numOfNumber; cols++) {
				if(rows == cols) continue;
				
				route[rows][cols] = MAX;
			}
		}
		
		// M번 만큼 반복하며 arr 배열 채워주기
		for(int idx=1; idx<=routeCount; idx++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end =  Integer.parseInt(st.nextToken());
			
			route[start][end] = 1;
			route[end][start] = 1;
		}
		
		// distance 채우기
		for(int idx=1; idx<=numOfNumber; idx++) {
			distance[idx] = route[startIdx][idx];
		}
		
		// 6. 배열을 순회하며 갱신
		visited[startIdx] = true;
		dikjstra(startIdx);
		
		if(distance[endIdx] == MAX) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(distance[endIdx]);
	}
	
	public static void dikjstra(int index) {
		// 6-1. distance 가 가장 짧은 Index 추출
		for(int i=0; i<numOfNumber; i++) {			
			int curIdx = getMinIndex();
			
			if(curIdx == -1) return;
			
			visited[curIdx] = true;
	
			// 	6-2. 가장 짧은 Index 기준 1~N 까지 다음으로 가는 반복문 생성
			for(int nextIdx=1; nextIdx<=numOfNumber; nextIdx++) {
				// 6-3. distance[nextIndex] > arr[minIndex][nextIndex] + distance[minIndex] 라면 distance 갱신
				if(!visited[nextIdx]) {
					if(distance[nextIdx] > route[curIdx][nextIdx] + distance[curIdx]) {
						distance[nextIdx] = route[curIdx][nextIdx] + distance[curIdx];
					}
				}
				
			}
		}
		
		
	}
	
	public static int getMinIndex() {
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		
		for(int idx=1; idx<=numOfNumber; idx++) {
			if(!visited[idx] && distance[idx] < min) {
				min = distance[idx];
				minIdx = idx;
			}
		}
		
		return minIdx;
	}

}
