class Solution {
   public  long solution(int price, int money, int count) {
        long answer = money;
        for(int i=1; i<=count; i++){
            answer = answer - price*i;
        }
        if(answer > 0)
            return 0;
        else
            answer = Math.abs(answer);

        return answer;
    }
}