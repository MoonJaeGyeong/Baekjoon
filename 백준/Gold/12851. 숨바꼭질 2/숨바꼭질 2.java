
import java.io.*;
import java.util.*;

/**
 * 
 * @author SSAFY
 * 1. N : 수빈이의 위치 , K : 동생의 위치
 * 2. queue 로 너비 우선순위 탐색
 * 3. 현재 수빈이의 위치(cur) 기준 K 보다 작아야만 순간이동(*2) 앞으로 가기(+1) 허용
 * 4. if(cur == K) 동일하면 몇 초 동안 이동 했는지 추출 후 min 값 갱신 
 * 	4-1. if min 값이랑 동일하다면 횟수 +1
 * 5. min, 횟수 값 출력 
 * 
 */

public class Main {
	static int N, K;
	static int min;
	static int n = 0;
	
	static final int SECOND = 1;
	static final int POINT = 0;
	static final int MAX = 100000;
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		N = sc.nextInt();
		K = sc.nextInt();
		min = Math.abs(N-K) + 1;
		int[] visited = new int[MAX + 1];
		
		for(int idx=0; idx<MAX + 1; idx++) {
			visited[idx] = min;
		}
		
		Deque<int[]> dq = new ArrayDeque<>();
		int[] cur = {N, 0};
		dq.add(cur);
		
		while(!dq.isEmpty()) {
			cur = dq.poll();
			
			if(cur[POINT] == K) {
				
				if(min == cur[SECOND]) {
					n++;
				}
				
				if(min > cur[SECOND]) {
					n = 1;
					min = cur[SECOND];
				}
			}
			
			if(cur[SECOND] >= min) continue;
			
			if(cur[POINT] < K && visited[cur[POINT]] >= cur[SECOND]) {
				dq.add(new int[] {cur[POINT]+1, cur[SECOND]+1});
				visited[cur[POINT]] = cur[SECOND]; 
			}
			
			if(cur[POINT] < K && cur[POINT]*2 - K + cur[SECOND] < min 
					&& visited[cur[POINT]] >= cur[SECOND] && cur[POINT] * 2 <= MAX) {
				dq.add(new int[] {cur[POINT]*2, cur[SECOND]+1});
				visited[cur[POINT]] = cur[SECOND]; 
			}
			
			if(cur[POINT] > 0 && visited[cur[POINT]] >= cur[SECOND]) {
				dq.add(new int[] {cur[POINT]-1, cur[SECOND]+1});
				visited[cur[POINT]] = cur[SECOND]; 
			}
		}
		
		System.out.println(min);
		System.out.println(n);
	}


}
