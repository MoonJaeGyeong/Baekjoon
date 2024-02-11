import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        StringBuffer sb = new StringBuffer(number);
        int max = -1;

        String reverse = sb.reverse().toString();
        String[] num = reverse.split(" ");

        for(String n : num){
            int n_i = Integer.parseInt(n);
            if(max < n_i){
                max = n_i;
            }
        }

        System.out.println(max);
    }
}
