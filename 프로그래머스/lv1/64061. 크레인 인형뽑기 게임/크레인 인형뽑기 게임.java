class Solution {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] basket = new int[1000];
        int m;
        int k=0, n=0;

        for(int i=0; i<moves.length; i++){
            m = moves[i]-1;
            int pick=101;
            n = 0;
            while(pick > 100){
                if(n==board.length) break;
                if(board[n][m] != 0){
                    pick = board[n][m];
                    board[n][m] = 0;
                }
                else
                    n++;
            }
            if(k != 0){
                if(pick == basket[k-1]) {
                    basket[--k] = 0;
                    answer+=2;
                }
                else if(pick<=100)
                    basket[k++] = pick;
            } else if(k == 0 && pick<=100)
                basket[k++] = pick;

        }
        return answer;
    }
}