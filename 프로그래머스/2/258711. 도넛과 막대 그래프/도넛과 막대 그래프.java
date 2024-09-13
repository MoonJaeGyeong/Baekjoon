import java.util.*;

class Solution {
    static int a;
    static int b = 0;
    static int c = 0;
    static int d = 0;

    public int[] solution(int[][] edges) {
        int max = -1;
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        for(int i=0; i<edges.length; i++){
            start.put(edges[i][0], start.getOrDefault(edges[i][0],0)+1);
            end.put(edges[i][1], end.getOrDefault(edges[i][1],0)+1);
        }

        for(int vertex : start.keySet()){
            if(!end.containsKey(vertex) && start.get(vertex) > 1){
                a = vertex;
            }

            if(start.get(vertex) >= 2){
                if(end.containsKey(vertex)){
                    d++;
                }
            }


        }

        for(int vertex : end.keySet()){
            if(!start.containsKey(vertex)){
                c++;
            }

        }

        b = start.get(a) - c - d;

        int[] answer = {a,b,c,d};
        return answer;
    }
}