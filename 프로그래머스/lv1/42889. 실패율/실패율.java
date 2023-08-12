import java.util.*;
import java.util.stream.Collectors;

class Solution {
      public static int[] solution(int N, int[] stages){
        int[] answer = new int[N];
        int[] p = new int[N+1];
        int[] fail = new int[N+1];
        int n = 0;
        double d;

        Map<Integer, Double> prob = new HashMap<>();
        List<Integer> numbers = Arrays.stream(stages)
                .boxed()
                .collect(Collectors.toList());

        for(int i=1; i<=N+1; i++){
            int cnt = Collections.frequency(numbers, i);
            fail[i-1] = cnt;

            for(int j=0; j<i; j++) {
                if (cnt==0) break;
                p[j] += cnt;
            }
        }

        for(int i=0; i<N; i++) {
            if(p[i] == 0)
                d = 0;
            else
                d = (double)fail[i] / (double)p[i];
            prob.put(i, d);
        }

        List<Integer> KeySet = new ArrayList<>(prob.keySet());
        KeySet.sort((o1,o2) -> prob.get(o2).compareTo(prob.get(o1)));

        for(Integer key : KeySet){
            answer[n] = key+1;
            n++;
        }

        return answer;
    }
}