import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] piece = input.split(" ");
        int[] rightChessPiece = {1, 1, 2, 2, 2, 8};
        int[] answer = new int[piece.length];

        for(int i=0; i<piece.length; i++){
            answer[i] = rightChessPiece[i] - Integer.parseInt(piece[i]);
        }

        for(int a : answer){
            System.out.print(a + " ");
        }
    }
}
