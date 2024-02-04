class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int i = 0;
        for(String[] people : photo){
            int yearnScore = 0;
            for(String person : people){
                int nameIndex = getIndex(name, person);
                if(nameIndex != -1){
                    yearnScore += yearning[nameIndex];
                }
            }
            answer[i] = yearnScore;
            i++;
        }
        return answer;
    }

    public int getIndex(String[] names, String s){
        int i = 0;
        for(String name : names){
            if(name.equals(s)){
                return i;
            }
            i++;
        }
        return -1;
    }
}