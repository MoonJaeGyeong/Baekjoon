import java.util.Arrays;

class Solution {
    public static int solution(int[] people, int limit) {
            int answer = 0;
            int kilo = 0;

            Arrays.sort(people);
            int n = people.length -1;
            int t = 0;
            while(people[n] <= limit){
                kilo = people[n]; // 제일 무거운 사람 넣기

                for(int i=t; i<n; i++){
                    if(kilo + people[i] > limit){
                        answer++;
                        people[n] = limit +1;
                        break;
                    } else {
                        answer++;
                        people[i] = limit +1;
                        people[n] = limit +1;
                        t++;
                        break;
                    }
                }
                if(n==0) break;
                if(people[--n] == limit+1){
                    n++;
                    break;
                }

            }

            if(people[n] != limit +1)
                answer++;

            return answer;
    }
           
}