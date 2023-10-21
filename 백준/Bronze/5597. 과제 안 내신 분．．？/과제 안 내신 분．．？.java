import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;

        int[] students = new int[30];

        for(int i=0; i<students.length; i++){
            students[i] = i+1;
        }

        for(int i=0; i<28; i++){
            a = sc.nextInt();
            students[a-1] = 0;
        }

        for(int i=0; i<students.length; i++){
            if (students[i] != 0) {
                System.out.println(i+1);
            }
        }
    }


}
