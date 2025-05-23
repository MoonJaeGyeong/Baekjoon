class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        if(dot[0] > 0){
            if(dot[1] < 0){
                answer = 4;
            }
            
            if(dot[1] > 0){
                answer = 1;
            }
        }
        
        if(dot[0] < 0){
            if(dot[1] < 0){
                answer = 3;
            }
            
            if(dot[1] > 0){
                answer = 2;
            }
        }
        return answer;
    }
}