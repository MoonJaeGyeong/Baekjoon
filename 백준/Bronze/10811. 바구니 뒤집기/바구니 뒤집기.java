import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int m;
        int a,b;
        int tmp;

        n = sc.nextInt();
        m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        for(int i=0; i<m; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            for(int j=a-1; j<b; j++){
                tmp = arr[j];
                arr[j] = arr[--b];
                arr[b] = tmp;
            }

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }



    }


}
