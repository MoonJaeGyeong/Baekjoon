import java.sql.Ref;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = 0,b = 0,c = 0;
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = 0;
        }

        for(int i=0; i<m; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            for(int j=a-1; j<b; j++){
                arr[j] = c;
            }
        }

        for(int i=0; i<n; i++){
            System.out.printf(arr[i] + " ");
        }
    }


}
