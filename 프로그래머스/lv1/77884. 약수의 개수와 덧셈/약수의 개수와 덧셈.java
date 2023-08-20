class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int n = 0;
        for(int i=left; i<=right; i++){
            n = NumOfMeasure(i);
            if(isEven(n))
                answer += i;
            else
                answer -= i;
        }
                
        return answer;
    }
    
    public int NumOfMeasure(int n){
        int m = 0;
        for(int i=1; i<n; i++){
            if(n%i ==0){
                m++;
            }
        }
        return m;
    }
    
    public boolean isEven(int n){
        if(n%2 ==0)
            return false;
        return true;
    }
}