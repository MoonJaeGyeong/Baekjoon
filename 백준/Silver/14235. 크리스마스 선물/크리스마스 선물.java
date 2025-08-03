import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> bag = new PriorityQueue<>(Comparator.reverseOrder());

        for(int repeat=0; repeat < N; repeat++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                int input = Integer.parseInt(st.nextToken());

                if(input == 0){
                    if(bag.isEmpty()) {
                        System.out.println("-1");
                    }
                    else{
                        System.out.println(bag.poll());
                    }


                }

                else {
                    for(int i=0; i < input; i++){
                        bag.add(Integer.parseInt(st.nextToken()));
                    }
                }

            }

        }
    }





}
