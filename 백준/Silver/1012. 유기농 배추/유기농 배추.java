import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int N,M,K,T;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;
    static int[] di = {1, -1, 0 , 0};
    static int[] dj = {0, 0, +1, -1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int k=0; k<T; k++){ // 2번 반복
            answer = 0;

            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            map = new int[N][M];
            visited = new boolean[N][M];
            for(int i=0; i<K; i++){
                int row = sc.nextInt();
                int col = sc.nextInt();
                map[row][col] = 1;
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        dfs(i,j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }

    }
    
    public static void dfs(int i, int j){
        for(int k=0; k<4; k++){
            int move_i = i + di[k];
            int move_j = j + dj[k];
            if(move_i >= 0 && move_i < N && move_j >=0 && move_j < M && map[move_i][move_j] == 1 && !visited[move_i][move_j]){
                visited[move_i][move_j] = true;
                dfs(move_i, move_j);
            }
        }

    }

}