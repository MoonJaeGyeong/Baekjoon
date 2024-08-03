import java.io.IOException;
import java.util.*;

class Main{
    static int N,M,K,T;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;
    static int[] di = {1, -1, 0 , 0, -1, -1, +1, +1};
    static int[] dj = {0, 0, +1, -1, -1, +1, -1, +1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        do {
            answer = 0;

            N = sc.nextInt();
            M = sc.nextInt();
            map = new int[M][N];
            visited = new boolean[M][N];

            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        dfs(i,j);
                        answer++;
                    }
                }
            }

            if(N == 0) break;
            System.out.println(answer);
        } while(N != 0);

    }

    public static void dfs(int i, int j){
        for(int k=0; k<8; k++){
            int move_i = i + di[k];
            int move_j = j + dj[k];
            if(move_i >= 0 && move_i < M && move_j >=0 && move_j < N && map[move_i][move_j] == 1 && !visited[move_i][move_j]){
                visited[move_i][move_j] = true;
                dfs(move_i, move_j);
            }
        }

    }

    public static void bfs(int i, int j){
        Queue<int[]> queue = new ArrayDeque<>();
        int[] ij = {i, j};
        queue.add(ij);

        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            for(int k=0; k<8; k++){
                int move_i = arr[0] + di[k];
                int move_j = arr[1] + dj[k];
                if(move_i >= 0 && move_i < M && move_j >=0 && move_j < N && map[move_i][move_j] == 1 && !visited[move_i][move_j]){
                    visited[move_i][move_j] = true;
                    int[] new_arr = {move_i, move_j};
                    queue.add(new_arr);
                }
            }
        }
    }

}