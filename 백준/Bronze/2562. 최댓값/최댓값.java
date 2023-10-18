import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = -1;
        int n;
        int index = 0;

        for(int i=0; i<9; i++){
            n = sc.nextInt();

            if(n>max){
                max = n;
                index = i+1;
            }
        }

        System.out.println(max + "\n" + index);
    }
}
