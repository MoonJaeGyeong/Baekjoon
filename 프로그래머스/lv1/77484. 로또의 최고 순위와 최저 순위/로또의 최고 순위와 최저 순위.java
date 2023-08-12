import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Map<Integer, Boolean> map = new HashMap<>();
        int zero = 0;
        int correct = 0;
        int high, low;
        for(int lotto : lottos){
            if(lotto == 0 && zero != 5)
                zero++;
            else
                map.put(lotto,true);
        }
        for(int win : win_nums)
            if(map.containsKey(win)) correct++;
        
        if(correct != 0)
            low = 7-correct;
        else
            low = 6;
        high = low - zero;
        answer[0] = high;
        answer[1] = low;
        return answer;
    }
}