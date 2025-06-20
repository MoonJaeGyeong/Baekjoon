class Solution {
    public int solution(int[] num_list) {
        
        for(int i=0; i<num_list.length; i++){
            int n = num_list[i];
            
            if(n < 0){
                return i;
            }
            
        }
        
        int answer = -1;
        return answer;
    }
}