import java.util.*;

public class Main {
    static int N, M, R;
    static int[] items;
    static List<Road>[] roads;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 지역 수
        M = sc.nextInt(); // 수색 범위
        R = sc.nextInt(); // 길 수

        items = new int[N + 1];
        roads = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            items[i] = sc.nextInt();
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < R; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = sc.nextInt();
            roads[a].add(new Road(b, l));
            roads[b].add(new Road(a, l));
        }

        for (int start = 1; start <= N; start++) {
            max = Math.max(max, dijkstra(start));
        }

        System.out.println(max);
    }

    static int dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.add(new Road(start, 0));

        while (!pq.isEmpty()) {
            Road cur = pq.poll();
            int now = cur.to;
            int cost = cur.cost;

            if (cost > dist[now]) continue;

            for (Road next : roads[now]) {
                int nextNode = next.to;
                int nextCost = cost + next.cost;

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new Road(nextNode, nextCost));
                }
            }
        }

        int total = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= M) total += items[i];
        }
        return total;
    }
}

class Road implements Comparable<Road> {
    int to, cost;

    Road(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    public int compareTo(Road o) {
        return this.cost - o.cost;
    }
}