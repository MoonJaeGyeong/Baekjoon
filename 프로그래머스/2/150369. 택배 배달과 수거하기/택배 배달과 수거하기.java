import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long d_sum = sum(deliveries);
        long p_sum = sum(pickups);
        int p_index = getLastIndex(pickups);
        int d_index = getLastIndex(deliveries);
        
        while(d_sum != 0 || p_sum != 0){
            int cap_d = 0;
            int cap_p = 0;
          
            answer += (p_index > d_index) ? 2*(p_index+1) : 2*(d_index+1);
       
            while(cap_d != cap && d_index >= 0){
                
                if(cap_d + deliveries[d_index] <= cap){
                    cap_d += deliveries[d_index];
                    d_sum -= deliveries[d_index];
                    deliveries[d_index] = 0;
                    d_index--;
                }
                else {
                    int gap = cap - cap_d;
                    deliveries[d_index] -= gap;
                    cap_d = cap;
                    d_sum -= gap;
                }
                
                while(d_index >= 0 && deliveries[d_index] == 0){
                    d_index--;
                }
                
            }
            
            while(cap_p != cap && p_index >= 0){
                
                if(cap_p + pickups[p_index] <= cap){
                    cap_p += pickups[p_index];
                    p_sum -= pickups[p_index];
                    pickups[p_index] = 0;
                    p_index--;
                }
                else {
                    int gap = cap - cap_p;
                    pickups[p_index] -= gap;
                    cap_p = cap;
                    p_sum -= gap;
                }
                
                while(p_index >= 0 && pickups[p_index] == 0){
                    p_index--;
                }
               
            }
        }
        
        return answer;
    }
    
    public long sum(int[] arr){
        long sum = 0;
        for(int a : arr){
            sum += a;
        }
        return sum;
    }
    
    public int getLastIndex(int[] arr){
        for(int i = arr.length-1; i >= 0; i--){
            if(arr[i] != 0){
                return i;
            }
        }
        
        return 0;
    }
}