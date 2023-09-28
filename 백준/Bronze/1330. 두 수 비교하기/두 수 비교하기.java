import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(solution(a,b));
    }

    public static String solution(int a, int b){
        if(a < b)
            return "<";
        else if(a > b)
            return ">";
        else
            return "==";
    }

}
