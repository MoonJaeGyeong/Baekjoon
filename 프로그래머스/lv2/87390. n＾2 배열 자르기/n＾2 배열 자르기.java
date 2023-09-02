class Solution {
 public int[] solution(int n, long left, long right){
        int[] answer = new int[(int)(right-left) +1];
        int[] arr = new int[n];
        int k = 0;
        long div, remain;

        for(int i=1; i<=n; i++){
            arr[i-1] = i;
        }

        for(long j=left+1; j<= right+1; j++){
            div =  (j/n) +1;
            remain =  j%n;

            if(remain == 0)
                answer[k] = n;
            else if(remain <= div)
                answer[k] = (int) div;
            else
                answer[k] = (int) remain;
            k++;
            }
        return answer;

    }
}