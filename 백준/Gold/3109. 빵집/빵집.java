
import java.util.*;
import java.io.*;

/**
 * 
 * @author SSAFY
 *1. R: 행, C : 열 입력
 *2. map[R][C] : map 초기화 . -> 0 / 'x' -> 1 입력
 *3. dy = [0, 1, -1] 0 : RIGHT, 1 : RIGHT_UP, 2 : RIGHT_DOWN
 *4. visited[R][C] 초기화
 *5. 그래프 탐색 시작
 *	5-0. 시작 : [0][0] 부터 ~ [R-1][0] 시작 지점 선정
 *	5-1. 완료 조건 : [?][C-1] 에 도착할 경우 pipe 하나 건설
 *	5-2. 완료 후 다음 idx 에서 시작
 *	5-3. for 0->3 nextCol, nextRow 를 구함
 *	5-4. nextRow < R && nextRow >= 0 && nextCol < C && !visited[nextRow][nextCol] && map[nextRow][nextCol] != 1
 *	5-5. visited[nextRow][nextCol] = true 로 바꾼 후 재귀 호출
 *	5-6. 매번 pipe 갯수 갱신
 *  
 * 6. max 출력
 *
 */

class Main{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int pipeline = 0;
	
	static int[] dy = {-1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int rows=0; rows<R; rows++) {
			String input = br.readLine();
			for(int cols=0; cols<C; cols++) {
				char c = input.charAt(cols);
				if(c == '.') map[rows][cols] = 0;
				else map[rows][cols] = 1;
			}
		}
		
		
		visited = new boolean[R][C];
		for(int idx=0; idx<R; idx++) {
			if(map[idx][0] == 1) continue;
			
			if(!visited[idx][0]) {
				visited[idx][0] = true;
				if(dfs(idx, 0)) pipeline++;
			}
		}
		
		System.out.println(pipeline);
	}
	
	public static boolean dfs(int row, int col) {
		if(col == C-1) {
			return true;
		}
		
		for(int i=0; i<3; i++) {
			int nextRow = row + dy[i];
			int nextCol = col + 1;
			if(nextRow < R && nextRow >= 0 && nextCol < C && !visited[nextRow][nextCol] && map[nextRow][nextCol] != 1) {
				visited[nextRow][nextCol] = true;
				if(dfs(nextRow, nextCol)) return true;
			}
			
		}
		
		return false;
	}
	
}