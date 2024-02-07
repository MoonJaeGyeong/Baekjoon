import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        String[] word = new String[repeat];

        for(int i=0; i<repeat; i++){
            String s = sc.next();
            word[i] = s.charAt(0) + "" + s.charAt(s.length()-1);
        }

        for(int i=0; i<repeat; i++){
            System.out.println(word[i]);
        }
    }
}
