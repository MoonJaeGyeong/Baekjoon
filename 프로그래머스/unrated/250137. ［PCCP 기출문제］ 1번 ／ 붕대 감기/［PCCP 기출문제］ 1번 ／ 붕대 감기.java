class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
         int current_health = health;
        int time = 1;
        int attack_timing = 0;
        int consecutive_heal = 0;

        while(attacks.length > attack_timing){
            if(attacks[attack_timing][0] == time){
                current_health -= attacks[attack_timing][1];
                attack_timing++;
                consecutive_heal = 0;
                if(current_health <= 0){
                    return -1;
                }
            }
            else {
                if(current_health < health){
                    current_health += bandage[1];
                    consecutive_heal++;
                } else if(current_health >= health){
                    consecutive_heal++;
                }
                if(consecutive_heal == bandage[0]){
                    current_health += bandage[2];
                    consecutive_heal = 0;
                }
                if(current_health > health){
                    current_health = health;
                }

            }
            time++;
        }
        return current_health;
    }
}