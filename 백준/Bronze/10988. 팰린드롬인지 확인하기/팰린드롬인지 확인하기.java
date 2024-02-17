import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        System.out.println(isPalindrome(word));
    }

    public static int isPalindrome(String word){
        for(int i=0; i<word.length()/2; i++){
            if(word.charAt(i) != word.charAt(word.length()-1-i)){
                return 0;
            }
        }
        return 1;
    }
}
