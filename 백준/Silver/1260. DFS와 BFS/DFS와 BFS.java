import java.io.IOException;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<LinkedList<Integer>> graph;
    static int start;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        start = sc.nextInt() - 1;
        graph = new ArrayList<>();
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            graph.add(new LinkedList<>());
        }

        for(int i=0; i<M; i++){
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            graph.get(row).add(col);
            graph.get(col).add(row);
        }

        for(int i=0; i<N; i++){
            Collections.sort(graph.get(i));
        }

        makedfs(start);
        System.out.println();
        makebfs();
    }

    public static void makedfs(int index){
        visited[index] = true;
        System.out.print(index+1 + " ");

        for(int i=0; i<graph.get(index).size(); i++){
            int n = graph.get(index).get(i);
            if(!visited[n]){
                visited[n] = true;
                makedfs(n);
            }
        }
    }

    public static void makebfs(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();

            for(int i=0; i<graph.get(node).size(); i++){
                int n = graph.get(node).get(i);
                if(!visited[n]){
                    queue.add(n);
                    visited[n] = true;
                }
            }

            System.out.print(node+1 + " ");
        }

    }
}
