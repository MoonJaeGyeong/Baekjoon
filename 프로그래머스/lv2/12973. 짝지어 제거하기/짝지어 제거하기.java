import java.util.Stack;

class Solution
{
    public static int solution(String s){
        int answer = 0;
        String suc = "";
        Stack<String> stack = new Stack<>();

        for(int i=1; i<=s.length(); i++){
            String spell = s.substring(i-1,i);
            if(stack.isEmpty())
                stack.push(spell);
            else{
                if(stack.peek().equals(spell))
                    stack.pop();
                else
                    stack.push(spell);

            }
        }
        
        if(stack.isEmpty())
            answer = 1;

        return answer;
    }
}