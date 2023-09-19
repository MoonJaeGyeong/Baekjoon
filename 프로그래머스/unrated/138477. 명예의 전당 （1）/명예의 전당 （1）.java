import java.util.ArrayList;
import java.util.Collections;

class Solution {
      public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> fame = new ArrayList<>();


        for(int i=0; i<score.length; i++){
            int s = score[i];
            
            if(i<k)
                fame.add(s);
            
            else{
                if(fame.get(0) < s){
                    fame.set(0,s);
                }
            }
            Collections.sort(fame);
            answer[i] = fame.get(0);

        }

        return answer;
    }
}