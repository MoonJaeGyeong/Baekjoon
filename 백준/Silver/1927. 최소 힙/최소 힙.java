import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int index=0; index<N; index++){
            int input =Integer.parseInt(br.readLine());

            if(input == 0){
                Integer num = pq.poll();
                if(num == null){
                    System.out.println(0);
                } else {
                    System.out.println(num);
                }

            }

            else {
                pq.add(input);
            }
        }
    }





}