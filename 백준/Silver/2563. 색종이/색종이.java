import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String xy;
        int paper = scanner.nextInt();
        scanner.nextLine();
        int[][] papers = new int[paper][2];
        int[][] drawBook = new int[100][100];

        int answer = 0;

        for(int i=0; i<paper; i++){
            xy = scanner.nextLine();
            String[] convert = xy.split(" ");
            papers[i][0] = Integer.parseInt(convert[0]);
            papers[i][1] = Integer.parseInt(convert[1]);

            for(int j=papers[i][0]; j<papers[i][0] + 10; j++){
                for(int k=papers[i][1]; k<papers[i][1] + 10; k++){
                    drawBook[j][k] = 1;
                }
            }
        }

        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                answer += drawBook[i][j];
            }
        }

        System.out.println(answer);

    }

}
