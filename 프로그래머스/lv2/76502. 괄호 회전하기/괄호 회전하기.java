import java.util.Stack;

class Solution {
  public  int solution(String s){
        int answer = 0;
        String rotation;
        for(int i=0; i<s.length(); i++){
            rotation = s.substring(i,s.length()) + s.substring(0,i);
            if(check(rotation))
                answer++;
        }
        return answer;
    }

    public  boolean check(String s){
        Stack<Character> stack = new Stack<>();
        char oc;
        for(int i=0; i<s.length(); i++){
            oc = s.charAt(i);

            if(stack.isEmpty()) {
                stack.push(oc);
                continue;
            }

            if((oc - stack.peek()) <= 2 && oc - stack.peek() > 0){
                stack.pop();
            }
            else{
                stack.push(oc);
            }

        }
        if(stack.isEmpty())
            return true;

        else
            return false;
    }
}