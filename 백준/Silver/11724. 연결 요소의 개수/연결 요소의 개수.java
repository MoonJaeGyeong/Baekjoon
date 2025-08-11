

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

/**
 * 
 * @author SSAFY
 *
 *1. N(serverNum) : 서버의 개수, M(connectNum) : 연결 정보 수 입력 받음2
 *2. servers[serverNum + 1] : 서버 정보 입력 배열 초기화 List<Integer> 를 받음 visited[serverNum + 1] 초기화
 *3. M 번 반복하면서 각 배열 Idx 에 연결된 네트워크 Idx List 에 추가
 *4. servers 순회 하면서 List.size() > 0 이면
 *	4-1. 해당 Idx의 visited 를 체크 후 connectQueue 에 집어 넣음
 *	4-2. while문 시작 리스트를 순회하면서 visited 체크 후 연결된 Idx를 Queue 에 집어 넣음
 *	4-3. Queue가 빌 때 까지 Idx에 있는 리스트를 모두 순회하면서 이 과정을 반복
 *	4-4. 한 사이클이 끝나면 network++
 *5. servers 다 순회 시 종료
 *6. network 출력
 *
 */

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int serverNum, connectNum;
	static List<Integer>[] servers;
	static boolean[] visited;
	static int network = 0;
	
	public static void init() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		serverNum = Integer.parseInt(st.nextToken());
		connectNum = Integer.parseInt(st.nextToken());
		
		// 2. servers[serverNum + 1] : 서버 정보 입력 배열 초기화 List<Integer> 를 받음 visited[serverNum + 1] 초기화
		servers = new ArrayList[serverNum + 1];
		visited = new boolean[serverNum + 1];
		
		for(int idx=0; idx<=serverNum; idx++) {
			servers[idx] = new ArrayList<Integer>();
		}
		
		// 3. M 번 반복하면서 각 배열 Idx 에 연결된 네트워크 Idx List 에 추가

		for(int i=0; i<connectNum; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int nextIdx = Integer.parseInt(st.nextToken());
			
			servers[idx].add(nextIdx);
			servers[nextIdx].add(idx);
		}
	}

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		System.setIn(new FileInputStream("Test3.txt"));
		// 4. servers 순회 하면서 List.size() > 0 이면
		init();
		Queue<Integer> connectQueue = new ArrayDeque<>();
		
		for(int idx=1; idx<=serverNum; idx++) {
			// 4-1. 해당 Idx의 visited 를 체크 후 connectQueue 에 집어 넣음
			if(visited[idx]) continue;
			
			connectQueue.add(idx);
			visited[idx] = true;
			
			// 	4-2. while문 시작 리스트를 순회하면서 visited 체크 후 연결된 Idx를 Queue 에 집어 넣음
			while(!connectQueue.isEmpty()) {
				int curIdx = connectQueue.poll();
				List<Integer> connectedServers = servers[curIdx]; 
				
				for(int conIdx : connectedServers) {
					if(!visited[conIdx]) {
						connectQueue.add(conIdx);
						visited[conIdx] = true;
					}
				}
				
				// 	4-3. Queue가 빌 때 까지 Idx에 있는 리스트를 모두 순회하면서 이 과정을 반복
				// 4-4. 한 사이클이 끝나면 network++
			}
			network++;
		
		}
		
		// 5. servers 다 순회 시 종료
		System.out.println(network);
	}

}
