import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Solution {

    public int solution(int[] scoville, int K) throws IOException {
        int answer = 0;
        PriorityQueue<Integer> food = new PriorityQueue<>();

        for(int repeat=0; repeat<scoville.length; repeat++){
            int scovil = scoville[repeat];
            food.add(scovil);
        }

        while(food.peek() < K && answer < 1000001){
            int first = food.poll();
            int second = food.poll();
            
            int newFood = first + (second * 2);

            if(food.size() == 0){
                if(newFood < K) {
                    return -1;
                }

                else {
                    answer++;
                    break;
                }

            }
            food.add(newFood);
            answer++;
        }

        return answer;
    }
}