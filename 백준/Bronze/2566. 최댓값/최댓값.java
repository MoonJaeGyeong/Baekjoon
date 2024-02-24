import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[9][9];
        int max = -1;
        int x = 0;
        int y = 0;

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                int input = scanner.nextInt();
                arr[i][j] = input;
                
                if(max < input){
                    max = input;
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(x + " " + y);
    }
}
