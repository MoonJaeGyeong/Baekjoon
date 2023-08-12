class Solution {
     public  int[] solution(String s){
        int n = 0;
        int zeroD = 0;

        while(!s.equals("1")){
            int before = s.length();
            s = s.replaceAll("0","");
            int after = s.length();
            zeroD += before - after;
            s = convert(s);
            n++;
        }
        int[] answer = {n, zeroD};
        return answer;
    }

    public  String convert(String s){
        int length = s.length();
        s = Integer.toBinaryString(length);
        return s;
    }
}