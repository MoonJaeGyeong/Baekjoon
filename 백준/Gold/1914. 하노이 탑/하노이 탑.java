import java.math.BigInteger;
import java.util.*;

class Main{
    static BigInteger dp[];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	dp = new BigInteger[N];
    	dp[0] = BigInteger.valueOf(1);
		for(int index=1; index<N; index++) {
    		dp[index] = dp[index-1].add(dp[index-1]).add(BigInteger.valueOf(1));
    	}
		
		sb.append(dp[N-1] + "\n");
		
		if(N <= 20) {
			hanoi(N, 3, 1);
		}
 
    	System.out.println(sb.toString());
    }
    
    public static void hanoi(int n, int obj, int cur) {
    	if(n == 0) return;
    	
    	int subObj = getSubObj(obj, cur);
    	hanoi(n-1, subObj, cur);
    	sb.append(cur + " " + obj + "\n");
    	hanoi(n-1, obj, subObj);
    	
    }
    
    public static int getSubObj(int target, int cur) {
		int subObj = 1;
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		for(int index=1; index<=3; index++) {
			if(index != target && index != cur) {
				subObj = index;
			}
		}
		
		return subObj;
	}
}