
import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int sum = 0;
		int start = 0;
		int end = 0;
		int min = 1000000;
		int answer = 0;
		int[] arr = new int[N];
		
		for(int index=0; index<N; index++) {
			arr[index] = sc.nextInt();
		}
		
		while(end <= N) {
			int length = end - start;
			
			if(sum < S) {
				if(end == N) break;
				
				sum += arr[end];
				end++;
			}
			
			else if(sum >= S) {
				
				if(length < min) {
					min = length;
					answer = min;
				}
				
				sum -= arr[start];
				start++;
			}

			
		}
		
		System.out.println(answer);
	}

}
