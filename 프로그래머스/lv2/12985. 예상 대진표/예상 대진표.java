import static java.lang.Math.abs;

class Solution
{
    
    public int solution(int n, int a, int b){
        int answer = 0;
        int s;
        if(a>b){
            s = a;
            a = b;
            b = s;
        }
    
        while(true){
             if(b-a == 1 && b%2 == 0)
                break;
            
            a = NextNumber(a);
            b = NextNumber(b);
            answer++;
           
        }
        
        answer++;
        return answer;
    }

    public int NextNumber(int n) {
        if (n % 2 == 0)
            n = n / 2;
        else
            n = (n + 1) / 2;

        return n;
    }
 
}