import java.util.HashMap;

class Solution {
  public String[] solution(String[] players, String[] callings){
        String[] answer = new String[players.length];
        HashMap<String, Integer> index = new HashMap<>();
        String temp;

        // 인덱스
        for(int i=0; i<players.length; i++)
            index.put(players[i], i);


        for(String name : callings){
            int i = index.get(name);
            temp = players[i];
            players[i] = players[i-1];
            players[i-1] = temp;

            index.put(players[i], i);
            index.put(players[i-1], i-1);
        }

        answer = players;
        return answer;

    }
}