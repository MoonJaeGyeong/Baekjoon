import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        int formation = scanner.nextInt();
        int sum = 0;

        for(int i=0; i<text.length(); i++){
            int num = text.charAt(text.length()-1-i);
            if(num >= 65){
                sum += Math.pow(formation,i) * (num - 55);
            }
           else {
                sum += Math.pow(formation,i) * (num - 48);
            }
        }
        System.out.println(sum);

    }

}
