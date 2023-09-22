import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
     public List<Integer> solution(int[] numbers) {

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<numbers.length; i++){
            int sum = numbers[i];
            for(int j=i+1; j<numbers.length;j ++){
                sum += numbers[j];

                if(!list.contains(sum)){
                    list.add(sum);
                }

                sum = numbers[i];
            }
        }

        Collections.sort(list);

        
        return list;
    }
}