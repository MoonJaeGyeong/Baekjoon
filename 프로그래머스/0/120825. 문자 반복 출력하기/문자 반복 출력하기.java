class Solution {
    public String solution(String my_string, int n) {
      StringBuilder result = new StringBuilder();
        
        for (char c : my_string.toCharArray()) {
            result.append(String.valueOf(c).repeat(n));
        }
        
        return result.toString();
    }
}