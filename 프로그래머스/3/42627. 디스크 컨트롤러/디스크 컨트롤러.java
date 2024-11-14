import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        int t = 0;
        List<int[]> list = new ArrayList<>();
        for(int[] arr : jobs){
            list.add(arr);
        }
        while(!list.isEmpty()){
            int size = list.size();
            int min = 9999999;
            int requestTime = 0;
            int index = 0;

            for(int i=0; i<size; i++){
                int[] arr = list.get(i);
                if(arr[0] <= t){
                    if(arr[1] < min){
                        min = arr[1];
                        requestTime = arr[0];
                        index = i;
                    }
                    else if(arr[1] == min){
                        if(arr[0] < requestTime){
                            requestTime = arr[0];
                            index = i;
                        }
                    }
                }
            }
            if(min == 9999999){
                t++;
                continue;
            }
            t += min;
            answer += t - list.get(index)[0];
            list.remove(index);
        }


        return answer/jobs.length;
    }
}