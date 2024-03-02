import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        int[][] coin = new int[repeat][4];

        for(int i=0; i<repeat; i++){
            int change = scanner.nextInt();
            coin[i][0] = change / 25;
            change %=  25;
            coin[i][1] = change / 10;
            change %= 10;
            coin[i][2] = change / 5;
            change %= 5;
            coin[i][3] = change / 1;

        }

        for(int i=0; i<repeat; i++){
            for(int j=0; j<4; j++){
                System.out.print(coin[i][j] + " ");
            }
            System.out.println();
        }
    }

}
