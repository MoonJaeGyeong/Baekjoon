class Solution {
    public double solution(double slice, double n) {
        double answer = 0;
        answer =  Math.ceil(n / slice);
        return answer;
    }
}