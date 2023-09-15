import java.util.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
         public  LinkedList<Integer> solution(int []arr) {

        LinkedList<Integer> list = new LinkedList<>();
        int n = 0;

        for(int i=0; i<arr.length; i++){
            if(list.isEmpty())
                list.add(arr[i]);

            else if(list.get(list.size()-1) != arr[i])
                list.add(arr[i]);
        }
  
        return list;
    }
}