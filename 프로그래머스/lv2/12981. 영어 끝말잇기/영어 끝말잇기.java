class Solution {
    public static int[] solution(int n,String[] words){
        int[] answer = {0,0};
        int i;
        boolean fail= false;


        for(i=0; i< words.length; i++){
            String before = words[i];
            if(i+1 == words.length) break;
            String after = words[i+1];
            if(!Spellcheck(before,after) || !Duplicatecheck(words, after,i) || !lengthcheck(after)){
                i+=2;
                fail=true;
                break;
            }
        }
        if(i%n == 0 && fail){
            answer[0] = n;
            answer[1] = i/n;
        }
        if(i>n && fail && !(i%n==0)){
            answer[0] = i%n;
            answer[1] = i/n + 1;
        }
        if(i<n && fail && !(i%n==0)){
            answer[0] = i;
            answer[1] = 1;
        }

        return answer;
    }

    public static boolean Spellcheck(String b,String a){
        if(b.charAt(b.length()-1) == a.charAt(0))
            return true;

        return false;
    }

    public static boolean Duplicatecheck(String[] s, String a, int i){
        for(int j=0; j<i; j++){
            if(s[j].equals(a))
                return false;
        }

        return true;
    }

    public static boolean lengthcheck(String a){
        if(a.length() >= 2)
            return true;

        return false;
    }
}