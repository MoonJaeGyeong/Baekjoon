import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score = new int[sc.nextInt()];
        int max = -1;
        double sum = 0;
        for(int i=0; i<score.length; i++){
            score[i] = sc.nextInt();
            sum += score[i];
            if(max < score[i]){
                max = score[i];
            }
        }

        double toParentScore = sum / score.length / max * 100;

        System.out.println(toParentScore);
    }
}
