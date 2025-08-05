import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			int cards = Integer.parseInt(br.readLine());
			pq.add(cards);
		}
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		while(pq.size() != 2) {
			int min = pq.poll();
			int secondMin = pq.poll();
			
			answer += min + secondMin;
			int newCards = min + secondMin;
			pq.add(newCards);
		}
		
		
		int first = pq.poll();
		int second = pq.poll();
		
		answer += first + second;
		
		System.out.println(answer);
	}

}
