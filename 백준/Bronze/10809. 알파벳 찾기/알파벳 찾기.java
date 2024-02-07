import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int[] alpha = new int[26];
        for(int i=0; i<alpha.length; i++){
            alpha[i] = -1;
        }

        for(int i=0; i<word.length(); i++){
            if(alpha[word.charAt(i) - 97] > i || alpha[word.charAt(i) - 97] == -1){
                alpha[word.charAt(i) - 97] = i;
            }

        }

        for(int i=0; i<alpha.length; i++){
            System.out.print(alpha[i] + " ");
        }

    }
}
