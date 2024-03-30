import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int m = sizes.length;
        int n = sizes[0].length;
        
        List<Integer> list_big = new ArrayList<>();
        List<Integer> list_small = new ArrayList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(sizes[i][0] < sizes[i][1]){
                    list_big.add(sizes[i][1]);
                    list_small.add(sizes[i][0]);
                } else {
                    list_big.add(sizes[i][0]);
                    list_small.add(sizes[i][1]);
                }
            }
        
        }
        list_big.sort(Comparator.naturalOrder());
        list_small.sort(Comparator.naturalOrder());
        
        int answer = list_small.get(list_small.size() -1) * list_big.get(list_big.size()-1);
        return answer;
    }
}