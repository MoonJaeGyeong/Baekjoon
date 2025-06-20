import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 물건의 개수
        int k = scanner.nextInt(); // 배낭의 최대 무게
        List<Thing> things = new ArrayList<>();

        for(int i=0; i<n; i++){
            int weight = scanner.nextInt(); // 물건의 무게
            int value = scanner.nextInt(); // 물건의 가치
            Thing thing = new Thing(weight, value);
            things.add(thing);

        }

        select(things, k);

    }

    public static void select(List<Thing> things, int k) {
        int n = things.size();
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            Thing thing = things.get(i - 1);
            for (int j = 0; j <= k; j++) {
                if (thing.getWeight() > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - thing.getWeight()] + thing.getValue());
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}


class Thing {
    int weight;
    int value;

    public Thing(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

}