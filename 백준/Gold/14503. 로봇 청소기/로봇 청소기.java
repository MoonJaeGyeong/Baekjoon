import java.util.*;

class Main{
    static int direct; // 0 : 북, 1: 동, 2: 남, 3: 서
    static int n;
    static int m;
    static int x;
    static int y;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, +1, 0};


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        y = sc.nextInt();
        x = sc.nextInt();
        direct = sc.nextInt();
        int cleanNum = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        while(true){
            if(map[y][x] == 0){
                map[y][x] = 2;
                cleanNum++;
            }

            int wall_or_clean = 0;
            int move_x;
            int move_y;

            for(int k=0; k<4; k++){
                move_x = x + dx[k];
                move_y = y + dy[k];
                if(checkCleanOrWall(move_x, move_y)){
                    wall_or_clean++;
                }
            }

            if(wall_or_clean == 4){
                int reverse_d = reverse();
                move_x = x + dx[reverse_d];
                move_y = y + dy[reverse_d];
                if(checkWall(move_x, move_y)){
                    break;
                }
                x = move_x;
                y = move_y;
            }

            else{
                rotate();
                move_x = x + dx[direct];
                move_y = y + dy[direct];

                if(checkUnclean(move_x, move_y)){
                    x = move_x;
                    y = move_y;
                }
            }
        }

        System.out.println(cleanNum);
    }

    public static boolean checkCleanOrWall(int x, int y){
        return (x < 0 || x >= m || y < 0 || y >= n || map[y][x] == 1 || map[y][x] == 2);
    }

    public static boolean checkWall(int x, int y){
        return (x < 0 || x >= m || y < 0 || y >= n || map[y][x] == 1);
    }

    public static boolean checkUnclean(int x, int y){
        return (x > 0 && y > 0 && x < m && y < n && map[y][x] == 0);
    }

    public static int reverse() {
        int[] reverseMap = {2, 3, 0, 1};
        return reverseMap[direct];
    }

    public static void rotate(){
        int[] rotateMap = {3, 0, 1, 2};
        direct = rotateMap[direct];
    }

}