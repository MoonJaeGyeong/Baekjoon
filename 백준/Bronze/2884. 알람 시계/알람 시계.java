import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int minute = sc.nextInt();

        int fix_minute = minute - 45;
        int fix_hour = hour;

        if(fix_minute < 0){
            fix_minute = fix_minute + 60;
            fix_hour = fix_hour == 0 ? 23 : fix_hour - 1;
        }

        System.out.println(fix_hour + " " + fix_minute);
    }

}
