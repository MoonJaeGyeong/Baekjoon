import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[][] graph;
    static int start;
    static boolean[] visited;
    static int[] dfs;
    static int[] bfs;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        start = sc.nextInt() - 1;
        graph = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<M; i++){
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            graph[row][col] = 1;
            graph[col][row] = 1;
        }

        makedfs(start);
        System.out.println();
        makebfs();
    }

    public static void makedfs(int index){
        visited[index] = true;
        System.out.print(index+1 + " ");

        for(int i=0; i<N; i++){
            if(graph[index][i] == 1 && !visited[i]){
                visited[i] = true;
                makedfs(i);
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

            for(int i=0; i<N; i++){
                if(graph[node][i] == 1 && !queue.contains(i) && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }

            System.out.print(node+1 + " ");
        }

    }
}