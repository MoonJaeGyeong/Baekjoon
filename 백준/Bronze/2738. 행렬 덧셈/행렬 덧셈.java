import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] xy = new String[2];
        xy = str.split(" ");

        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);

        int[][] arr = new int[x][y];

        for(int k=0; k<2; k++){
            for(int i=0; i<x; i++){
                for(int j=0; j<y; j++){
                    int input = scanner.nextInt();
                    arr[i][j] += input;
                }
            }
        }

        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
