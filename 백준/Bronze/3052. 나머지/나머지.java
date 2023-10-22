import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int same = 0;

        int[] arr = new int[10];

        for(int i=0; i<10; i++){
            a = sc.nextInt();
            arr[i] = a%42;
        }

        for(int i=0; i<10; i++){
            for(int j=i+1; j<10; j++){
                if(arr[i] == arr[j]) {
                    same++;
                    break;
                }
            }
        }

        System.out.println(10-same);


    }


}
