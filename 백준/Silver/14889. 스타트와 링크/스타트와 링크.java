import java.util.Scanner;

public class Main {
    static int t_min = 9999;
    static int N;
    static int[][] people;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        people = new int[N][N];
        used = new boolean[N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                people[i][j] = sc.nextInt();
            }
        }

        choice(0,0);
        System.out.println(t_min);
    }

    static void choice(int idx, int cnt){
        if(cnt == N/2){
            int start = 0;
            int link = 0;
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    if(used[i]){
                      if(used[j]){
                         start += people[i][j];
                         start += people[j][i];
                      }

                    }
                    else {
                        if(!used[j]){
                            link += people[i][j];
                            link += people[j][i];
                        }
                    }
                }
            }
            t_min = Math.min(t_min, Math.abs(start - link));
            return;
        }

        if(idx == N) return;


        used[idx] = true;
        choice(idx+1, cnt+1);
        used[idx] = false;
        choice(idx+1, cnt);
    }
}
