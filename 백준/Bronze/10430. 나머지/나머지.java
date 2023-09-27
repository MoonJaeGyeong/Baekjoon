import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        for(int i=0; i<4; i++){
            switch (i){
                case 0:
                    System.out.println((A+B)%C);
                    break;
                case 1:
                    System.out.println(((A%C) + (B%C))%C);
                    break;
                case 2:
                    System.out.println( (A*B)%C);
                    break;
                case 3:
                    System.out.println( ((A%C) * (B%C))%C);
                    break;
            }
        }
    }
    
}