
import java.util.*;
import java.io.*;

/**
 * 
 * @author SSAFY
 *1. T : 테스트 케이스 입력
 *2. N: 숫자의 갯수
 *3. cal[N-1], number[N-1], selectedCal[N-1], visisted[N-1] 선언
 *4. 순열 시작
 *	4-1. 기저 조건 cnt == N-1 이면 종료
 *	4-2. for(0->N-1) 까지 if visited 면 continue
 *	4-3. 아니면 selectedCal[cnt] = value 및 visisted[idx] = true;
 *	4-4. permutation(cnt+1);
 *	4-5. visited[idx] = false;
 *	4-6. 기저 조건 을 만날 시 계산 하여 max, min 계산
 *
 * 5. max - min 값 출력
 */

class Solution{
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int T, N;
	
	static int[] cal, numbers, selectedCal;
	static boolean[] visited;
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void init() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		for(int test_case=1; test_case<=T; test_case++) {
			N = Integer.parseInt(br.readLine());
			cal = new int[N-1];
			numbers = new int[N];
			selectedCal = new int[N-1];
			visited = new boolean[N-1];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			int calIdx = 0;
			for(int i=0; i<4; i++) {
				int repeat = Integer.parseInt(st.nextToken());
				for(int r=0; r<repeat; r++) {
					cal[calIdx] = i;
					calIdx++;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int idx=0; idx<N; idx++) {
				numbers[idx] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(cal);
			calculate();
			boolean isEnd = nextpermutation();
			
			while(!isEnd) {
				calculate();
				isEnd = nextpermutation();
			}
			
			int answer = max - min;
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");			
		}
		
		System.out.println(sb);
		
	}
	
	public static boolean nextpermutation() {
		// 4-1. 가장 뒤에서 부터 연산 시작
		int curIdx = N-2;
		int curValue = cal[curIdx];
		int prevIdx = curIdx - 1;
		
		while(prevIdx >= 0) {
			int prevValue =  cal[prevIdx];
			if(prevValue < curValue) {
				for(int idx=N-2; idx>=0; idx--) {
					 //4-2-2. curIdx-1 값이 작을 경우 1번 교환 진행 후 종료
					if(cal[idx] > prevValue) {
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
		
		if(prevIdx == -1) return true;
		
		
		sortTail(curIdx);
		return false;
	}
	
	public static void sortTail(int startIdx) {
		int size = N-startIdx-1;
		int[] tmpPer = new int[size];
		
		for(int idx=startIdx; idx<N-1; idx++) {
			tmpPer[idx-startIdx] = cal[idx];
		}
		Arrays.sort(tmpPer);
		for(int idx=startIdx; idx<N-1; idx++) {
			cal[idx] = tmpPer[idx-startIdx];
		}
		
	}
	
	public static void swap(int prev, int cur) {
		int tmp = cal[prev];
		cal[prev] = cal[cur];
		cal[cur] = tmp;
		
	}
	
	public static void calculate() {
		int sum = numbers[0];
		int numberIdx = 1;
		
		for(int idx=0; idx<N-1; idx++) {
			int c = cal[idx];
			int number = numbers[numberIdx];
			
			switch(c) {
			case 0:
				sum += numbers[numberIdx];
				break;
				
			case 1:
				sum -= numbers[numberIdx];
				break;
				
			case 2:
				sum *= numbers[numberIdx];
				break;
				
			case 3:
				sum /= numbers[numberIdx];
				break;
			}
			
			numberIdx++;
		}
		
		if(max < sum) {
			max = sum;
		}
		
		if(min > sum) {
			min = sum;
		}
	
	}
}