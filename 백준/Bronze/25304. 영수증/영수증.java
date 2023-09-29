import javax.xml.transform.Source;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();
        int n = sc.nextInt();

        int price, ea;
        int sum = 0;

        for(int i=0; i<n; i++){
            price = sc.nextInt();
            ea = sc.nextInt();

            sum += price*ea;
        }

        if(total == sum)
            System.out.println("Yes");
        else
            System.out.println("No");

    }

}
