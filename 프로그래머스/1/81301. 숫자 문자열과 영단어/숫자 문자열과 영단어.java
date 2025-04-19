import java.lang.*;

class Solution {
    public static String[] arr = {"zero", "one", "two", "three", "four", 
                                  "five", "six", "seven", "eight", "nine"};
    
    public static String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    
    public int solution(String s) {
        String answer = "";
        String word = "";
        for(int i=0; i<s.length(); i++){
            String str = s.substring(i, i+1);
            if(isNumber(str)){
                answer += str;
                continue;
            }
            
            word += str;
            for(int j=0; j<arr.length; j++){
                if(arr[j].equals(word)){
                    answer += String.valueOf(j);
                    word = "";
                }
            }
        }
        
        return Integer.parseInt(answer);
    }
    
    public boolean isNumber(String str){
        for(String number : numbers){
            if(number.equals(str)){
                return true;
            }
        }
        
        return false;
    }
}