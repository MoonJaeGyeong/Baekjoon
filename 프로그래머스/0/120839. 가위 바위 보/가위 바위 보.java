import java.lang.*;
import java.util.*;

class Solution {
    
    public String solution(String rsp) {
        StringBuilder answer = new StringBuilder();
        for(int index=0; index<rsp.length(); index++){
            char computer = rsp.charAt(index);
            
            if(computer == '2'){
                answer.append("0");
            }
            
            else if(computer == '0'){
                answer.append("5");
            }
            
            else if(computer == '5'){
                answer.append("2");
            }
        }

        return answer.toString();
    }
}