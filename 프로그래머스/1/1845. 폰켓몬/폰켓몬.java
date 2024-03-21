import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> phoneKetmon = new HashSet<>();
        for(int n : nums){
            phoneKetmon.add(n);
        }
        
        if(phoneKetmon.size() > nums.length/2){
            answer = nums.length/2;
        } else {
            answer = phoneKetmon.size();
        }
        return answer;
    }
}