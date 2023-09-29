import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a,b;

        for(int i=0; i<n; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println(a+b);
        }

    }



}
