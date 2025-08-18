import java.io.*;
import java.util.*;

/**
 * 
 * @author SSAFY
 *1. N : 전쟁터의 가로, M : 전쟁터의 세로 길이
 *2. BW 로 이루어진 map[][] 초기화
 *3. 방문하지 않은 곳을 0,0 부터 -> N,M 까지 모두 탐색
 *	3-1. W 시작 시 W가 끊기기 전까지 모두 더하고 제곱
 *	3-2. B 시작 시 동일하게 탐색
 *4. int[] answer 를 차례로 출력 
 *
 *
 */
public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static int min = Integer.MAX_VALUE;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int rows=0; rows<N; rows++) {
			String row = br.readLine();
			for(int cols=0; cols<M; cols++) {
				char c = row.charAt(cols);
				if(c == '1') {
					map[rows][cols] = 1;
				}
				
				else {
					map[rows][cols] = 0;
				}
				
			}
		}
		
		bfs();
		System.out.println(min);
		
	}
	
	
	public static void bfs() {
		int[] start = {0, 0, 1};
		visited[0][0] = true;
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(start);
		
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int curRow = cur[0];
			int curCol = cur[1];
			int distance = cur[2];
			
			if(curRow == N-1 && curCol == M-1) {
				min = Math.min(distance, min);
			}
			
			for(int idx=0; idx<4; idx++) {
				int nextRow = curRow + dx[idx];
				int nextCol = curCol + dy[idx];
				int nextDistance = distance + 1;
				
				if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
					dq.add(new int[]{nextRow, nextCol, nextDistance});
					visited[nextRow][nextCol] = true;
				}
			}
			
		}
		
	}

}
