import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Solution {
      public  long solution(long n) {
        long answer = 0;
        ArrayList arrayList = new ArrayList<>();
        List<String> list = new ArrayList<>();


        String s = Long.toString(n);
        for(int i=0; i<s.length(); i++){
            list.add(s.substring(i,i+1));
        }

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            String num = String.valueOf(list.get(i));
            answer += Math.pow(10,i) * Long.parseLong(num);
        }
        return answer;
    }
}