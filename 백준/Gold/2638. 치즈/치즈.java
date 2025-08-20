import java.util.*;
import java.io.*;

/**
 * 
 * @author SSAFY
 *1. N : rows, M : cols 입력 받음 
 *2. map[N][M] 초기화
 *3. map 전체 탐색하면서 if map[row][col] == 1 이면
 *	3-1. 4방향 탐색 후 if 방문했다면 이라면
 *	3-2. 외부 공기인지 내부 공기인지 판단
 *	3-3. 외부공기라 판단되면 맞 닿아있는 변 outside++
 *	3-5. outside == 2 라면 해당 치즈는 1시간 후 녹아 없어질 치즈로 nextMap 에 0으로 초기화
 *	3-6. map 전체 탐색 후 map = nextMap (* 주소 복사 안하게)
 *4. 1이 모두 사라졌는지 판단
 *	4-1. 사라졌으면 치즈가 다 녹았다 판단 후 종료 및 출력
 *	4-2. 아직 남아있다면 사라질 때 까지 위를 반복   
 */

public class Main {
	static int N,M;
	static int[][] map;
	static int[][] nextMap;
	static boolean[][] visited;
	static boolean[][] nextVisited;
	
	static int[] dr = {-1, 0, 1, 0}; // 위 왼 아래 오른
	static int[] dc = {0, -1, 0, 1};
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		nextMap = new int[N][M];
		visited = new boolean[N][M];
		nextVisited = new boolean[N][M];
		
		for(int rows=0; rows<N; rows++) {
			for(int cols=0; cols<M; cols++) {
				int input = sc.nextInt();
				map[rows][cols] = input;
				nextMap[rows][cols] = input;
			}
		}
		
		int hours = 0;
		
		
		while(true) {
			hours++; // 시간 경과
			visited = new boolean[N][M];
			bfs(0, 0);
			
			for(int rows=0; rows<N; rows++) {
				for(int cols=0; cols<M; cols++) {
					int cheese = map[rows][cols];
					
					if(cheese == 0) continue;
					
					int outside = 0;
					
					for(int i=0; i<4; i++) {
						int nextRow = rows + dr[i];
						int nextCol = cols + dc[i];
						
						if(visited[nextRow][nextCol]) {
							outside++;
						}
						
						if(outside == 2) break; // 이미 2변이 바깥 공기라면
					}
					
					if(outside == 2) {
						map[rows][cols] = 0;
					}
				}
			}
			
			if(isCheeseEmpty()) break; // cheese 다 없어지면 나가기
		}
		
		System.out.println(hours);
	}
	
	public static boolean isCheeseEmpty() {
		
		for(int rows=0; rows<N; rows++) {
			for(int cols=0; cols<M; cols++) {
				if(map[rows][cols] == 1) return false;
			}	
		}
		
		return true;
	}
	
	public static void bfs(int row, int col) {
		Deque<int[]> dq = new ArrayDeque<>();
		visited[row][col] = true;
		dq.add(new int[] {row, col});
		
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int curRow = cur[0];
			int curCol = cur[1];
			
			for(int i=0; i<4; i++) {
				int nextRow = curRow + dr[i];
				int nextCol = curCol + dc[i];
				
				if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && !visited[nextRow][nextCol] && map[nextRow][nextCol] == 0) {
					visited[nextRow][nextCol] = true;
					nextVisited[nextRow][nextCol] = true;
					dq.add(new int[] {nextRow, nextCol});
				}
			}
		}
	}
}
