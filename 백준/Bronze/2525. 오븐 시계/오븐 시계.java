import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int min = sc.nextInt();
        int time = sc.nextInt();

        int d_hour = hour + time / 60;
        int d_min = min + time % 60;

        if(d_min >= 60){
            d_min -= 60;
            d_hour += 1;
        }

        if(d_hour >= 24)
            d_hour -= 24;


        System.out.println(d_hour + " " + d_min);


    }

}
