import java.io.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int a = -1;
        int b = -1;

        while(true){
            a = sc.nextInt();
            b= sc.nextInt();

            if(a == 0 && b == 0)
                break;

            System.out.println(a+b);
        }


    }
}
