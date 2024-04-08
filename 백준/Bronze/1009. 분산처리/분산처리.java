
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        int a,b;
        int answer;

        for(int i=0; i<repeat; i++){
            a = scanner.nextInt();
            b = scanner.nextInt();
            b = b % 4;

            if(b == 0) b=4;

            answer = (int)Math.pow(a,b) % 10;
            
            if(answer == 0 ) answer = 10;
            System.out.println(answer);
        }
        

    }


}
