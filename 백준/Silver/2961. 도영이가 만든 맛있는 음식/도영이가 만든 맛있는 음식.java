import java.util.Scanner;

public class Main {
    public static int t_min = 99999;
    public static int N;
    static int[][] ingredients;
    static boolean[] used;
    public static final int SOUR = 0;
    public static final int BITTER = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        ingredients = new int[N][2];
        used = new boolean[N];

        for(int i=0; i<N; i++){
            for(int j=0; j<2; j++){
                ingredients[i][j] = sc.nextInt();
            }
        }

        choice(0,0);
        System.out.println(t_min);
    }

    static void choice(int idx, int cnt){

        if(idx == N && cnt > 0){
            int sour = 1;
            int bitter = 0;
            for(int i=0; i<N; i++){
                if(used[i]){
                    sour *= ingredients[i][SOUR];
                    bitter += ingredients[i][BITTER];
                }
            }
            t_min = Math.min(t_min, Math.abs(sour - bitter));
            return;
        }

        if(idx == N) return;

        used[idx] = true;
        choice(idx+1, cnt+1);
        used[idx] = false;
        choice(idx+1, cnt);
    }
}
