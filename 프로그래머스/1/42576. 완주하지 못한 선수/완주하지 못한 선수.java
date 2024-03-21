import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
       String answer = "";
        HashMap<String, Integer> participanHashMap = new HashMap<>();
        for(String s : completion){
            if(participanHashMap.containsKey(s)){
                participanHashMap.replace(s, participanHashMap.get(s)+1);
            }
            else{
                  participanHashMap.put(s,1);
            }
        }

        for(String s : participant){
            if(!participanHashMap.containsKey(s)){
                answer = s;
            }
            else{
                if(participanHashMap.get(s) == 1){
                    participanHashMap.remove(s);
                } else if(participanHashMap.get(s) > 1){
                    participanHashMap.replace(s, participanHashMap.get(s) -1);
                }
            }
        }


        return answer;
    }
}