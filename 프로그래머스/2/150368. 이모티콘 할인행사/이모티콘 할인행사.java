import java.util.*;

class Solution {
    static List<Integer> discountEmoticons = new ArrayList();
    static int[] discounts = {10, 20, 30, 40};
    static int emotionPlus = 0;
    static int emotionSum = 0;
    

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        backtracking(users, emoticons, 0);
        
        answer[0] = emotionPlus;
        answer[1] = emotionSum;
        return answer;
    }
    
    public void backtracking(int[][] users, int[] emoticons, int n){
        
        if(discountEmoticons.size() == emoticons.length){
            int[] subAndSum = getEmotionSum(users, emoticons);
            
            if(subAndSum[0] > emotionPlus){
                emotionPlus = subAndSum[0];
                emotionSum = subAndSum[1];
                return;
            }
            
            if(subAndSum[0] == emotionPlus && subAndSum[1] > emotionSum){
                emotionPlus = subAndSum[0];
                emotionSum = subAndSum[1];
            }
            
            return;
        }
        
        for(int i=n; i<discounts.length; i++){
            discountEmoticons.add(discounts[i]);
            backtracking(users, emoticons, n);
            discountEmoticons.remove(discountEmoticons.size() - 1);
        }
        
    }
    
    public int[] getEmotionSum(int[][] users, int[] emoticons){
        int plusSub = 0;
        int emoSum = 0;

        for(int[] user : users){
            int sum = 0;
            
            for(int i=0; i<discountEmoticons.size(); i++){
                if(user[0] <= discountEmoticons.get(i)){
                    sum = sum + emoticons[i] * ((100 - discountEmoticons.get(i))) / 100;
                }
            }
            
            if(user[1] <= sum){
                plusSub++;
                continue;
            }
            
            emoSum += sum;
        }
        
        int[] arr = new int[2];
        arr[0] = plusSub;
        arr[1] = emoSum;
        return arr;
    }
    
}