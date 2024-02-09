import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] word = sentence.strip().split(" ");

        if(sentence.equals("") || sentence.equals(" ")){
            System.out.println(0);
        }
        else {
            System.out.println(word.length);
        }

    }
}
