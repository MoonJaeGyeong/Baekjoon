
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] after_map;
    static int answer;
    static int max_answer = 0;

    static int[] di = {0, 0, -1, +1};
    static int[] dj = {1, -1, 0 , 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        int n = -1; // 반복 횟수

        for(int i=0; i<N; i++){ // 맵 생성
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] > n){
                    n = map[i][j];
                }
            }
        }

        for(int height=0; height<=n; height++){ // 1 ~ 최대 높이 - 1 까지 반복
            after_map = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] > height){ // 홍수 높이보다 높으면
                        after_map[i][j] = 1; // 0 : 잠긴 곳, 1: 안잠긴 곳
                    }
                }
            }

            answer = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(after_map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }
            if(max_answer < answer){
                max_answer = answer;
            }
        }

        System.out.println(max_answer);
    }

    public static void bfs(int i, int j){
        visited[i][j] = true;

        for(int k=0; k<4; k++){
            int move_i = i + di[k];
            int move_j = j + dj[k];
            if(move_i >= 0 && move_i < N && move_j >= 0 && move_j < N && !visited[move_i][move_j] && after_map[move_i][move_j] == 1){
                bfs(move_i, move_j);
            }
        }

    }
}
