import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dice_one = sc.nextInt();
        int dice_two = sc.nextInt();
        int dice_thr = sc.nextInt();

        int answer = solution(dice_one,dice_two,dice_thr);

        System.out.println(answer);
    }

    public static int solution(int a, int b, int c){
        int reward = 0;

        if(a == b && b == c)
            reward = 10000 + 1000 * a;
        else if(a == b)
            reward = 1000 + 100 * a;
        else if(b == c)
            reward = 1000 + 100 * b;
        else if(c == a)
            reward = 1000 + 100 * c;
        else
            reward = 100 * (Math.max(a,b) == b ? Math.max(b,c) : Math.max(a,c));

        return reward;
    }

}
