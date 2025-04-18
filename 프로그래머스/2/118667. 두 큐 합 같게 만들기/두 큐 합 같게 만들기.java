import java.util.*;

class Solution {
    public int solution(int[] queue_1, int[] queue_2) {
        Queue<Integer> queue1 = new ArrayDeque();
        Queue<Integer> queue2 = new ArrayDeque();
        
        for(int i=0; i<queue_1.length; i++){
            queue1.add(queue_1[i]);
            queue2.add(queue_2[i]);
        }
        
        long qOneSum = sum(queue1);
        long qTwoSum = sum(queue2);
        int n = 0;
        
        while(!queue1.isEmpty() && !queue2.isEmpty() && n <= 4*queue_1.length){
            
             if(qTwoSum == qOneSum){
                return n; 
            }
            
            if(qOneSum > qTwoSum){
                int qOnePop = queue1.poll();
                qOneSum -= qOnePop;
                queue2.add(qOnePop);
                qTwoSum += qOnePop;
            }
            else if(qOneSum < qTwoSum) {
                int qTowPop = queue2.poll();
                qTwoSum -= qTowPop;
                queue1.add(qTowPop);
                qOneSum += qTowPop;
            }
            n++;
            
        }
        
        return -1;
    }
    
    public long sum(Queue<Integer> queue){
        long sum = 0;
        for(int q : queue){
            sum += q;
        }
        
        return sum;
    }
}