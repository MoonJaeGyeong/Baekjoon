class Solution {
    static int answer = 0;

    public int solution(int hp) {
        int[] ants = {5, 3, 1};

        for(int ant : ants){
            hp = attack(ant, hp);
        }

        return answer;
    }

    public int attack(int ant, int hp){
        while(hp >= 0){
            hp -= ant;
            answer++;
        }

        hp += ant;
        answer--;

        return hp;   
    }
}