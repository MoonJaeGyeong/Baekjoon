import java.util.Arrays;

class Solution {
   public  int solution(String[] spell, String[] dic){
        int answer = 1;
        boolean[] tf = new boolean[dic.length];
        boolean[] ft = new boolean[dic.length];

        for(int i=0; i<dic.length; i++){
            tf[i] = true;
            ft[i] = false;
        }

        for(String s : spell){
            for(int i=0; i<dic.length; i++){
                if(tf[i])
                    if(!dic[i].contains(s) || dic[i].length() > spell.length)
                        tf[i] = false;
            }
            if(Arrays.equals(tf,ft)){
                answer = 2;
                break;
            }
        }


        return answer;
    }
}