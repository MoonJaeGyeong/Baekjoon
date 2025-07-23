class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[end_num - start_num + 1];
        
        for(int index=0; index<answer.length; index++){
            answer[index] = start_num;
            start_num++;
        }
        
        return answer;
    }
}