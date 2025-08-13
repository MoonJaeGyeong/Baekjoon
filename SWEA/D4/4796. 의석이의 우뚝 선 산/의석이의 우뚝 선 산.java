
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

/**
 * 
 * @author SSAFY
 *1. T : 테스트 케이스 입력
 *2. N : 산의 갯수 입력
 *3. mountains[N] : 산의 높이 입력
 *4. mountains idx 1-> N-1 까지 탐색
 *	4-1. mountains[idx-1] < mountains[idx] < mountains[idx+1]  인 idx 를 찾는다
 *	4-2. idx를 기준으로 left 로 작아지는 수의 갯수를 구함, idx를 기준으로 right 로 작아지는 수의 갯수를 구함
 *	4-3. idxHighMoutains = left*right + 기본 1 + left + right
 *	4-4 sum += idxHighMoutains 
 */

class Solution{
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb  = new StringBuilder();
	
	static int T, N;
	static int[] mountains;
	static int sum;
	
	public static void main(String[] args) {
		T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			N = sc.nextInt();
			mountains = new int[N];
			sum = 0;
			for(int idx=0; idx<N; idx++) {
				mountains[idx] = sc.nextInt();
			}
			
			for(int idx=1; idx<N-1; idx++) {
				if(mountains[idx-1] < mountains[idx] && mountains[idx] > mountains[idx+1]) {
					int left = 0;
					int right = 0;
					int idxHighMountains = 1;
					
					int leftIdx = idx -1;
					int rightIdx = idx + 1;
	
					while(leftIdx > 0 && mountains[leftIdx-1] < mountains[leftIdx]) {
						left++;
						leftIdx--;
					}
					
					while(rightIdx < N-1 && mountains[rightIdx+1] < mountains[rightIdx]) {
						right++;
						rightIdx++;
					}
					
					idxHighMountains += left*right + left + right;
					sum += idxHighMountains;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(sum).append('\n');
			
		}
		System.out.println(sb);
	}
}