import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        int point = 1;
        for(int i=0; i<repeat; i++){
            point *= 2;
        }
        point += 1;
        System.out.println(point*point);

    }

}
