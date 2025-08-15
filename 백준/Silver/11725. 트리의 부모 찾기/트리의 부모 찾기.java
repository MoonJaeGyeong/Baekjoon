import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N;
    static Scanner sc = new Scanner(System.in);
    static int[] answer;
    static List<Integer>[] tree;
    static boolean[] visited;
    
    public static void main(String[] args) {
        N = sc.nextInt();
        answer = new int[N+1];
        visited = new boolean[N+1];
        tree = new ArrayList[N+1];
        Queue<Integer> queue = new ArrayDeque<>();

        for(int idx=1; idx<=N; idx++){
            tree[idx] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            int pre = sc.nextInt();
            int next = sc.nextInt();

            tree[pre].add(next);
            tree[next].add(pre);
        }

        queue.add(1);

        while(!queue.isEmpty()){
            int parent = queue.poll();

            for(int child : tree[parent]){
                if(!visited[child]){
                    answer[child] = parent;
                    visited[child] = true;
                    queue.add(child);
                }
            }
        
        }

    
        for(int idx=2; idx<=N; idx++){
             System.out.println(answer[idx]);
        }
    }
}