class Solution {
    public int solution(int a, int b) {
        String an = String.valueOf(a);
        String bn = String.valueOf(b);
        
        String sum = an+bn;
        int answer = Integer.parseInt(sum);

        int mul = 2*a*b;
        if(mul > answer){
            answer = mul;
        }
        
        return answer;
    }
}