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
	static int[] answer = new int[4];
	
	static final int WHITE = 2;
	static final int BLUE = 3;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			String people = br.readLine();
			
			for(int j=0; j<N; j++) {
				if(people.charAt(j) == 'W') {
					map[i][j] = 2;
				}
				
				if(people.charAt(j) == 'B') {
					map[i][j] = 3;
				}
			}
		}
		
		for(int rows=0; rows<M; rows++) {
			for(int cols=0; cols<N; cols++) {
				if(!visited[rows][cols]) {
					bfs(new int[] {rows, cols});
				}
				
			}
		}
		
		System.out.println(answer[WHITE] + " " + answer[BLUE]);
	
		
	}
	
	
	public static void bfs(int[] start) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start[0]][start[1]] = true;
		int startN = map[start[0]][start[1]];
		int number = 1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curRow = cur[0];
			int curCol = cur[1];
			
			for(int idx=0; idx<4; idx++) {
				int nextRow = curRow + dx[idx];
				int nextCol = curCol + dy[idx];
				
				if(nextRow >= 0 && nextRow < M && nextCol >= 0 && nextCol < N && map[nextRow][nextCol] == startN && !visited[nextRow][nextCol]) {
					queue.add(new int[]{nextRow, nextCol});
					visited[nextRow][nextCol] = true;
					number++;
				}
			}
			
		}
		
		answer[startN] += number * number;
	}

}
