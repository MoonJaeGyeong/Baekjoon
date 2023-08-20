class Solution {
   public int solution(int n){
        int answer = 0;
        StringBuilder t = new StringBuilder(Integer.toString(n,3));

        answer = Integer.parseInt(t.reverse().toString(),3);

        return answer;
    }
}