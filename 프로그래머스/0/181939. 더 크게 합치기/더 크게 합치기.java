class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String a_n = String.valueOf(a);
        String b_n = String.valueOf(b);
        
        int sum = Integer.parseInt(a_n + b_n);
        answer = Integer.parseInt(b_n + a_n);
        
        if(answer < sum){
            answer = sum;
        }
        
        return answer;
    }
}