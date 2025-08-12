
import java.io.*;

import java.util.*;

/**
 * 
 * @author SSAFY
 *
 *1. N : 순열의 마지막 수 입력
 *2. permutation[] 수열 순서대로 입력
 *3. if(permutation[0->N]) N, N-1, N-2 일 경우 -1 출력
 *4. 아니면 nextpermutation() 실행
 *	4-1. 가장 뒤에서 부터 연산 시작
 *	4-2. if(curIdx-1 값이 큰 거 일 경우)
 *		4-2-1. curIdx-1 값이 작을 때 까지 반복
 *		4-2-2. curIdx-1 값이 작을 경우 1번 교환 진행 후 종료
 *5. permutation[] 출력 
 */
class Main{
	
	static int N;
	static int[] permutation;
	
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void init() throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		permutation = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int idx=0; idx<N; idx++) {
			permutation[idx] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		boolean isLast = true;
		
		// if(permutation[0->N]) N, N-1, N-2 일 경우 -1 출력
		for(int idx=0; idx<N; idx++) {
			if(permutation[idx] != N-idx) {
				isLast = false;
			}
		}
		
		if(isLast) {
			System.out.println(-1);
			return;
		}
		nextpermutation();
		for(int idx=0; idx<N; idx++) {
			System.out.print(permutation[idx] + " ");
		}
		
	}
	
	public static void nextpermutation() {
		// 4-1. 가장 뒤에서 부터 연산 시작
		int curIdx = N-1;
		int curValue = permutation[curIdx];
		int prevIdx = curIdx - 1;
		
		while(prevIdx >= 0) {
			int prevValue =  permutation[prevIdx];
			if(prevValue < curValue) {
				for(int idx=N-1; idx>=0; idx--) {
					 //4-2-2. curIdx-1 값이 작을 경우 1번 교환 진행 후 종료
					if(permutation[idx] > prevValue) {
						swap(idx, prevIdx);
						break;
					}
				}
				break;
			}
			
			// 4-2. if(curIdx-1 값이 큰 거 일 경우)
			 //4-2-1. curIdx-1 값이 작을 때 까지 반복
		
			curIdx = prevIdx;
			curValue = prevValue;
			prevIdx--;
		}
		
		sortTail(curIdx);
	}
	
	// 접미사 정렬
	public static void sortTail(int startIdx) {
		int size = N-startIdx;
		int[] tmpPer = new int[size];
		
		for(int idx=startIdx; idx<N; idx++) {
			tmpPer[idx-startIdx] = permutation[idx];
		}
		Arrays.sort(tmpPer);
		for(int idx=startIdx; idx<N; idx++) {
			permutation[idx] = tmpPer[idx-startIdx];
		}
		
	}
	
	public static void swap(int prev, int next) {
		int tmp = permutation[prev];
		permutation[prev] = permutation[next];
		permutation[next] = tmp;
	}
}