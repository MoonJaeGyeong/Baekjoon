class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";
            int[] mbti = {0,0,0,0}; // RT , CF , JM , AN
            String[][] mbti_s = { {"R","T"}, {"C","F"},{"J","M"}, {"A","N"}};

            int length = survey.length;

            for(int i=0; i<length; i++){
                int n = choices[i] - 4; // 매우 아님 -3 , 매우 맞음 +3

                if(survey[i].contains("R")){
                    mbti[0] += (survey[i].equals("RT")) ? n : -1 * n;
                }
                else if(survey[i].contains("C")){
                    mbti[1] += (survey[i].equals("CF")) ? n : -1 * n;
                }
                else if(survey[i].contains("J")){
                    mbti[2] += (survey[i].equals("JM")) ? n : -1 * n;
                }
                else if(survey[i].contains("A")){
                    mbti[3] += (survey[i].equals("AN")) ? n : -1 * n;
                }
            }
            for(int i=0; i<4; i++){
                if(mbti[i] <= 0){
                    answer += mbti_s[i][0];
                }
                else if(mbti[i] > 0){
                    answer += mbti_s[i][1];
                }
            }
            return answer;
        }
    }