import static java.lang.Math.abs;

class Solution {
          public  String solution(int[] numbers, String hand){ // 1, 4, 7 left : 3, 6, 9 Right
        int L_distance = 0;
        int R_distance = 0;
        int L_location = 10; // *
        int R_location = 12; // #
        int n;
        String answer = "";

        for(int i=0; i< numbers.length; i++){
            n  = (numbers[i] == 0) ? numbers[i] + 11 : numbers[i];

            L_distance = getDistance(L_location,n);
            R_distance = getDistance(R_location,n);
            if(n == 1 || n == 4 || n == 7)
                answer += "L";
            else if(n == 3 || n == 6 || n == 9)
                answer += "R";

            else{
                if(L_distance > R_distance)
                    answer += "R";
                else if(L_distance < R_distance)
                    answer += "L";
                else // 같으면
                    answer += hand.substring(0,1).toUpperCase();
            }
            char last = answer.charAt(answer.length()-1);

            if(last == 'L')
                L_location = n;
            else
                R_location = n;
        }
        return answer;
    }

    public  int getDistance(int location,int number){
        int distance = 0;
        int lmn = abs(location - number);

        if(lmn == 1)
            distance = 1;
        else if(lmn == 4 || lmn == 2)
            distance = 2;
        else if(lmn == 5 || lmn == 7)
            distance = 3;
        else if(lmn == 8 || lmn == 10)
            distance = 4;
        else if(lmn % 3 == 0)
            distance = lmn / 3;


        return distance;
    }
}