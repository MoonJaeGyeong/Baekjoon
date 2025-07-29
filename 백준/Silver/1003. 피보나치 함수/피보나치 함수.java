import java.util.*;

class Main{
    static int[][] dp = new int[41][2];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int TC = sc.nextInt();
        fibonachi(41);
        
        for(int test_case=1; test_case <= TC; test_case++){
            int input = sc.nextInt() + 1;    
            System.out.println(dp[input-1][0] + " " + dp[input-1][1]);
        }
    }
    
    
    public static void fibonachi(int n){
 
        dp[0][0] = 1;
        dp[1][1] = 1;
        
        for(int index=2; index<n; index++){
            dp[index][0] += dp[index-2][0] + dp[index-1][0];
            dp[index][1] += dp[index-2][1] + dp[index-1][1];
        }
    }
}