
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;

/**
 * 
 * @author SSAFY
 *1. V: 정점의 개수, E: 간선의 개수 입력
 *2. distnace[V+1], map[V+1][V+1], visited[V+1] 생성
 *3. curPos : 현재 위치 입력
 *4. E 번 만큼 map 에 방향 그래프 입력 및 초기화 
 *5. distance[V+1] 에서 방문하지 않은 가장 작은 distance idx 값 추출
 *6. 방문 처리 후 minIdx -> nextIdx 값을 비교
 *7. map[minIdx][nextIdx] + distance[minIdx] < distance[nextIdx] 시 갱신
 *8. distance[1~V] 까지 출력
 *
 */

class Main{
	
	static final int INF = 999999999;
	
	static int V, E;
	static int[] distance;
	static List<Edge>[] map;
	static boolean[] visited;
	static int curIdx;
	
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void init() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		distance = new int[V+1];
		visited = new boolean[V+1];
		map = new ArrayList[V+1];
		
		for(int idx=0; idx<=V; idx++) {
			map[idx] = new ArrayList<>();
		}
		
		curIdx = Integer.parseInt(br.readLine());
	}
	
	public static void main(String[] args) throws IOException {
		
		init();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int pIdx = Integer.parseInt(st.nextToken());
			int nIdx = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			Edge edge = new Edge(nIdx, cost);
			map[pIdx].add(edge);
		}
		
		for(int idx=0; idx<=V; idx++) {
			distance[idx] = INF;
		}
		
		dikjstra(curIdx);
		
		
		for(int idx=1; idx<=V; idx++) {
			if(distance[idx] == INF) {
				System.out.println("INF");
				continue;
			}
			
			System.out.println(distance[idx]);
		}
		
		
		
	}
	
	public static void dikjstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Edge edge = new Edge(start, 0);
		distance[start] = 0;
		pq.add(edge);
		
		while(!pq.isEmpty()) {
			Edge curEdge = pq.poll();
			int curIdx = curEdge.endIdx;
			
			if(visited[curIdx]) continue;
			
			visited[curIdx] = true;
			
			for(Edge nextEdge : map[curIdx]) {
				int nextIdx = nextEdge.endIdx;
				if(distance[nextIdx] > distance[curIdx] + nextEdge.cost) {
					distance[nextIdx] = distance[curIdx] + nextEdge.cost;
					pq.add(new Edge(nextIdx, distance[nextIdx]));
				}
			}
			
		}
	}
	
}

class Edge implements Comparable<Edge> {
	int endIdx;
	int cost;
	
	public Edge(int endIdx, int cost) {
		this.endIdx = endIdx;
		this.cost = cost;
	}
	
	
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}