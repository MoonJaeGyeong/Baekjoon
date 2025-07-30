import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        double sum = 0;
        double[][] point = new double[N][2];
        
        for(int index=0; index<N; index++){
            point[index][0] = sc.nextInt();
            point[index][1] = sc.nextInt();
        }
        
        for(int index=0; index<N; index++){
        	
        	if(index == N-1) {
        		sum += (point[index][0] * point[0][1]) - (point[index][1] * point[0][0]); 
        		break;
        	}
        	
            sum += (point[index][0] * point[index+1][1]) - (point[index][1] * point[index+1][0]); 
        }
        
        double answer = Math.abs(sum/2.0);
        System.out.printf("%.1f\n", answer);
    
        
    }
}
