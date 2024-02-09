import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        List<String> answer = new ArrayList<>();

        for(int i=0; i<repeat; i++){
            int repeat_number = sc.nextInt();
            String word = sc.next();
            String repeat_word = "";

            for(int m=0; m<word.length(); m++){
                for(int n=0; n<repeat_number; n++){
                    repeat_word += word.charAt(m);
                }
            }
            answer.add(repeat_word);
        }

        for(String ans : answer){
            System.out.println(ans);
        }

    }
}
