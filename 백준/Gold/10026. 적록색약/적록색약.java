
import java.util.Scanner;

public class Main {
    static String[][] map;
    static boolean[][] visited;
    static int N;
    static int[] di = {0, 0, -1, +1};
    static int[] dj = {+1, -1, 0, 0};
    static int answer = 0;
    static int answer_for = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        visited = new boolean[N][N];
        map = new String[N][N];

        for(int i=0; i<N; i++){
            String str = sc.nextLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.substring(j,j+1);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    answer++;
                }
            }
        }

        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    dfs_for(i,j);
                    answer_for++;
                }
            }
        }

        System.out.println(answer + " " + answer_for);
    }

    public static void dfs(int i, int j){
        visited[i][j] = true;
        String rgb = map[i][j];

        for(int k=0; k<4; k++){
            int move_i = i + di[k];
            int move_j = j + dj[k];
            if(move_i >= 0 && move_i < N && move_j >= 0 && move_j < N && !visited[move_i][move_j] && map[move_i][move_j].equals(rgb)){
                dfs(move_i,move_j);
            }
        }

    }

    public static void dfs_for(int i, int j){
        visited[i][j] = true;
        String rgb = map[i][j];

        for(int k=0; k<4; k++){
            int move_i = i + di[k];
            int move_j = j + dj[k];
            if(move_i >= 0 && move_i < N && move_j >= 0 && move_j < N && !visited[move_i][move_j]){
                if(rgb.equals("R") || rgb.equals("G")){
                    if(map[move_i][move_j].equals("R") || map[move_i][move_j].equals("G"))
                        dfs_for(move_i,move_j);
                } else {
                    if(map[move_i][move_j].equals("B")){
                        dfs_for(move_i,move_j);
                    }
                }
            }
        }

    }

}
