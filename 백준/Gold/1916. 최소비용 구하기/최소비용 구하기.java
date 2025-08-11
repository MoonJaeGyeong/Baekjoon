
import java.io.IOException;
import java.io.*;
import java.util.*;

/**
 * 
 * @author SSAFY
 *
 *1. N : 도시의 개수, M : 버스 정보 입력 받음
 *2. cities[N+1][N+1], distance[N+1] 배열 초기화 (전부 INF로 초기화)
 *3. M 개의 줄 만큼 cities[start][end], cities[end][start] cost 값 넣기
 *4. startIdx, endIdx 값 입력 받기
 *5. startIdx 기준 distance[] 값 초기화
 *6. 거리 최적화
 *	6-1. distance 중 가장 짧은 Idx 뽑기
 *	6-2. 짧은 Idx -> nextIdx 0~N 까지 거리 탐색
 *	6-3 distance[nextIdx] = Math.min(distance[nextIdx], distance[minIdx] + cities[minIdx][nextIdx])
 *7. 도착 distance[endIdx] 출력
 */

public class Main {
	
	static int[][] cities;
	static int[] distance;
	static boolean[] visited;
	
	static int N;
	static int M;
	
	static int startIdx;
	static int endIdx;
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static final int INF = 999999999;
	
	public static void init() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		// 1. N : 도시의 개수, M : 버스 정보 입력 받음
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		// 2. cities[N+1][N+1], distance[N+1] 배열 초기화 (전부 INF로 초기화)
		cities = new int[N+1][N+1];
		distance = new int[N+1];
		visited = new boolean[N+1];
		
		for(int rows=0; rows<=N; rows++) {
			for(int cols=0; cols<=N; cols++) {
				if(rows==cols) continue;
				
				cities[rows][cols] = INF;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		init();
		
		// 3. M 개의 줄 만큼 cities[start][end], cities[end][start] cost 값 넣기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int pIdx = Integer.parseInt(st.nextToken());
			int nIdx = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			cities[pIdx][nIdx] = Math.min(cost, cities[pIdx][nIdx]);
		}
		
		st = new StringTokenizer(br.readLine());
		
		// 4. startIdx, endIdx 값 입력 받기
		startIdx = Integer.parseInt(st.nextToken());
		endIdx = Integer.parseInt(st.nextToken());
		
		// 5. startIdx 기준 distance[] 값 초기화
		for(int idx=0; idx<=N; idx++) {
			distance[idx] = cities[startIdx][idx];
		}
		
		visited[startIdx] = true;
		// 6. 거리 최적화
		for(int i=0; i<N; i++) {
			// 6-1. distance중 가장 짧은 Idx 뽑기
			int minIdx = getMinIdx();
			if(minIdx == INF) break;
			
			visited[minIdx] = true;
			
			// 6-2. 짧은 Idx -> nextIdx 1~N 까지 거리 탐색
			for(int nextIdx=1; nextIdx<=N; nextIdx++) {
				//6-3 distance[nextIdx] = Math.min(distance[nextIdx], distance[minIdx] + cities[minIdx][nextIdx])
				distance[nextIdx] = Math.min(distance[nextIdx], distance[minIdx] + cities[minIdx][nextIdx]);
			}
		}
		
		System.out.println(distance[endIdx]);
	}
	
	public static int getMinIdx() {
		int minIdx = INF;
		int minDistance = INF;
		
		for(int idx=1; idx<=N; idx++) {
			if(minDistance > distance[idx] && !visited[idx]) {
				minDistance = distance[idx];
				minIdx = idx;
			}
		}
		
		return minIdx;
	}

}
