class Solution {
    public static int solution(int[] sides) {
 int answer = 0;
        int sum = 0, max = 0;
        int min = 1001;

        for(int i : sides){
            sum += i;
            if(i > max) {
                max = i;
            }
            if(i < min)
                min = i;
        }

        answer += sum - max - 1 + min;

        return answer = (sum-max == 1) ? 1 : answer;
    }
}