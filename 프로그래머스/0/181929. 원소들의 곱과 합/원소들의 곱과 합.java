class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int mul = 1;
        int squSum = 0;
        
        for(int num : num_list){
            mul = num * mul;
            squSum += num;
        }
        squSum = squSum * squSum;
        
        if(squSum > mul){
            answer = 1;
        }
        
        return answer;
    }
}