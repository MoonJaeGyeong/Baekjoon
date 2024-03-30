    import java.lang.*;
    import java.util.*;

    class Solution {
        public List<Integer> solution(int[] answers) {
            int a=0;
            int b=0;
            int c=0;
            int n=0,m=0,k=0;

            int[] a_answer = {1,2,3,4,5};
            int[] b_answer = {2,1,2,3,2,4,2,5};
            int[] c_answer = {3,3,1,1,2,2,4,4,5,5};

            for(int i=0; i<answers.length; i++){
                
                if(n==5){
                    n = 0;
                }
                if(m==8){
                    m = 0;
                }
                if(k==10){
                    k = 0;
                }

                if(a_answer[n] == answers[i]){
                    a++;
                }
                if(b_answer[m] == answers[i]){
                    b++;
                }
                if(c_answer[k] == answers[i]){
                    c++;
                }

                n++;
                m++;
                k++;
            }
            int[] person = {a,b,c};
            int max = Math.max(a, Math.max(b,c));
            
            List<Integer> answer = new ArrayList<>();
            
            for(int i=0; i<3; i++){
                if(max == person[i]){
                    answer.add(i+1);
                }
            }
            return answer;
        }
    }