import java.util.HashMap;
import java.util.Map;

class Solution {
   public  int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        int dif;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(!map.containsKey(c)) {
                map.put(c,i);
                dif = -1;
            }
            else{
                dif = i - map.get(c);
                map.put(c,i);
            }
            answer[i] = dif;
        }

        return answer;
    }
}