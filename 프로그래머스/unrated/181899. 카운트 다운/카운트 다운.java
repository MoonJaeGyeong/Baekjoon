import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(int start, int end_num){
        List<Integer> answer = new ArrayList<Integer>();
        for(int i=start; i>=end_num; i--)
            answer.add(i);
        return answer;
    }
}