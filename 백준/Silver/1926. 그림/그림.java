import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int picture_length = 0;
        int picture_max = 0;
        int[] di = {0, 0, -1, 1};
        int[] dj = {1, -1, 0, 0};
        Queue<int[]> queue = new ArrayDeque();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
                visited[i][j] = false;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1 && visited[i][j] == false){
                    int[] ij = {i, j};
                    queue.add(ij);
                    visited[i][j] = true;
                    int length = 1;

                    while(!queue.isEmpty()){
                        int[] xy = queue.poll();
                        for(int k=0; k<4; k++){
                            int move_i = xy[0] + di[k];
                            int move_j = xy[1] + dj[k];

                            if(move_i >= 0 && move_j >= 0 && move_i < n && move_j < m && visited[move_i][move_j] == false
                                    && map[move_i][move_j] == 1){
                                queue.add(new int[]{move_i, move_j});
                                length += 1;
                                visited[move_i][move_j] = true;
                            }

                        }
                    }
                    picture_length++;
                    if(picture_max < length){
                        picture_max = length;
                    }
                }
            }
        }

        System.out.println(picture_length);
        System.out.println(picture_max);

    }
}