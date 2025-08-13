
import java.io.*;
import java.util.StringTokenizer;

/**
 * 
 * @author SSAFY
 *1. T : 테스트 케이스 입력
 *2. fee[4] 1일, 1개월, 3개월, 1년 요금
 *3. min = 1년 요금
 *4. 12개월의 visitPlan[12] 입력
 *5. getFee(int sumFee, int idx)
 *	5-1. 가지 치기 조건 sumFee > min 넘어가면 그냥 return
 *	5-2. 종료 조건 idx >= 11 넘어가면 종료 및 min 갱신
 *	5-3. 한달 Pass getFee(sumFee + fee[1], idx+1)
 *	5-4. 3개월 Pass getFee(sumFee + fee[2], idx+3)
 *	5-5. 1일 Pass getFee(sumFee + fee[0] * visitPlan[idx], idx+1)
 *
 *6. 갱신된 min 출력
 */

class Solution{
	
	static int T;
	static int min;
	static int[] fee, visitPlan;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		fee = new int[4];
		visitPlan = new int[12];
	
		for(int idx=0; idx<4; idx++) {
			fee[idx] = Integer.parseInt(st.nextToken());
		}
		
		min = fee[3];
		
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<12; idx++) {
			visitPlan[idx] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int test_case=1; test_case<=T; test_case++) {
			input();
			getFee(0 ,0);
			sb.append("#").append(test_case).append(" ").append(min).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void getFee(int sumFee, int idx) {
		if(idx >= 12) {
			min = Math.min(min, sumFee);
			return;
		}
		
		if(sumFee > min) {
			return;
		}
		
		if(visitPlan[idx] == 0) {
			getFee(sumFee, idx+1);
			return;
		}
		
		
		
		getFee(sumFee + fee[1], idx+1);
		getFee(sumFee + fee[0] * visitPlan[idx], idx+1);
		getFee(sumFee + fee[2], idx+3);
	}
}