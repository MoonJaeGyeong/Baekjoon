import java.util.Stack;

class Solution {
      public static int solution(String dartResult){
        Stack<Integer> n = new Stack<>();
        Stack<String> w = new Stack<>();
        int Asc;
        char word;
        int c = 0 , answer = 0, number = 0, number1;

        for(int i=0; i<dartResult.length(); i++){
            word = dartResult.charAt(i);
            Asc = (int) word;

            if(Asc >= 48 && Asc <= 57){  // 숫자라면
               n.push(Asc - 48);
               c++;
               if(c == 2 && n.peek() == 0) {
                   n.pop(); n.pop();
                   n.push(10);
               }

            } else { // 문자라면
                if(word == '#')
                   n.push(n.pop() * (-1));
                else if(word == 'S' || word == 'D' || word == 'T')
                    n.push(getPow(n.pop(), word));
                else {
                   number = n.pop() * 2;
                    if(!n.isEmpty()) { // n 이 차있으면
                        number1 = n.pop() * 2;
                        n.push(number1);
                    }
                    n.push(number);
                }
                c = 0;
            }
        }
        while(!n.isEmpty())
            answer += n.pop();

        return answer;
    }

    public static int getPow(int number, char word){
        int pow = number;  // Single

        if(word == 'D') // Double
            pow = number * number;
        else if(word == 'T') // Triple
            pow = number * number * number;
        return pow;
    }
}