import java.util.*;

class Solution {
    public String solution(String s) {
        String[] number = s.split(" ");
        List<Integer> numberList = new ArrayList<>();
        for(String n : number){
            numberList.add(Integer.parseInt(n));
        }
        
        numberList.sort(Comparator.naturalOrder());
        String answer = "";
        
        answer += String.valueOf(numberList.get(0)) + " ";
        answer += String.valueOf(numberList.get(numberList.size()-1));
        return answer;
    }
}