import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int up = scanner.nextInt();
        int down = scanner.nextInt();
        int total = scanner.nextInt();

        total -= up;
        int day = up - down;
        int answer = total/day + 1;

        if(total % day > 0){
            answer++;
        }

        System.out.println(answer);
    }

}
