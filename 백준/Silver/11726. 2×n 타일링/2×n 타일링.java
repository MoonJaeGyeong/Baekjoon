import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    public static long solution(int n){
        long[] arr = new long[n];
        
        if(n<=2){
            return n;
        }
        
        arr[0] = 1;
        arr[1] = 2;

        for(int i=2; i<n; i++){
            arr[i] = (arr[i-1] + arr[i-2])%10007;
        }

        return arr[n-1];
    }
}