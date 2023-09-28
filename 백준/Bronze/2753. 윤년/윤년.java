import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        System.out.println(solution(year));
    }

    public static int solution(int year){
        int bool = 0;

        if(year % 400 == 0)
            bool = 1;
        else if(year % 100 == 0)
            bool = 0;
        else if(year % 4 == 0)
            bool = 1;

            return bool;
    }

}
