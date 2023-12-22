import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0 ,-1};
    int n,m;
    boolean[][] visited;
    int[][] oil;
    int[][] land;

    public int solution(int[][] land){
       this.n = land.length;
       this.m = land[0].length;
       this.visited = new boolean[n][m];
       this.oil = new int[n][m];
       this.land = land;

       int oilID = 0;
       Map<Integer, Integer> oilSize = new HashMap<>();

       for(int i=0; i<n; i++){
           for(int j=0; j<m; j++){
               if(land[i][j] == 1 && !visited[i][j]){
                   int size = bfs(i ,j, oilID);
                   oilSize.put(oilID, size);
                   oilID++;
               }
           }
       }

       int max = -1;

       boolean[] visited_oil = new boolean[oilID];

       for(int j=0; j<m; j++){
           int sum = 0;
           for(int i=0; i<n; i++){
               if(land[i][j] == 1 && !visited_oil[oil[i][j]]){
                   sum += oilSize.get(oil[i][j]);
                   visited_oil[oil[i][j]] = true;
               }
           }

           for(int s=0; s< visited_oil.length; s++){
               visited_oil[s] = false;
           }
           if(max < sum){
               max = sum;
           }
       }

       return max;
    }

    private  int bfs(int x, int y, int oilID){
        int size = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        oil[x][y] = oilID;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && land[nx][ny] == 1){
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    oil[nx][ny] = oilID;
                    size++;
                }
            }
        }

        return size;
    }
}