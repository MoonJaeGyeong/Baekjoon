import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int point = scanner.nextInt();
        point -= 1;
        int start = 6;
        int six = 12;
        int room = 2;

        while(point > start){
            start += six;
            six += 6;
            room++;
        }

        if(point == 0){
            System.out.println(1);
        }
        else {
            System.out.println(room);
        }

    }

}
