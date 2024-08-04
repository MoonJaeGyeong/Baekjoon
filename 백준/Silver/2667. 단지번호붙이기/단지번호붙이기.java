import java.io.IOException;
import java.util.*;

class Main{
    static int[] di = {0, 0, -1, +1};
    static int[] dj = {-1, +1, 0, 0};
    static int N;
    static ArrayList<Integer> numberOfHouse = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;
    static int numberOfHousing;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        visited = new boolean[N][N];
        map = new int[N][N];

        for(int i=0; i<N; i++){
            String str = sc.nextLine();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    numberOfHousing = 0;
                    dfs(i,j);
                    answer++;
                    numberOfHouse.add(numberOfHousing);
                }
            }
        }
        Collections.sort(numberOfHouse);

        System.out.println(answer);
        for(int i=0; i<numberOfHouse.size(); i++)
            System.out.println(numberOfHouse.get(i));
    }

    public static void dfs(int i, int j){ // 스택
        visited[i][j] = true;
        numberOfHousing++;

        for(int k=0; k<4; k++){
            int move_i = i + di[k];
            int move_j = j + dj[k];
            if(move_i >= 0 && move_i < N && move_j >= 0 && move_j < N && map[move_i][move_j] == 1 && !visited[move_i][move_j]){
                dfs(move_i,move_j);
            }
        }

        return;
    }

    public static void bfs(int i, int j){ // 큐

    }


}