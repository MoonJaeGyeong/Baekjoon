import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(solution(x,y));
    }

    public static int solution(int x ,int y){
        int answer = 0;

        if(x > 0 && y > 0)
            answer = 1;
        else if(x < 0 && y > 0)
            answer = 2;
        else if(x < 0 && y < 0)
            answer = 3;
        else if(x > 0 && y < 0)
            answer = 4;

        return answer;
    }



}
