import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=1; i<=2*n-1; i++){

            if(i<=n){
                for(int k=1; k<=i; k++){
                    System.out.print("*");
                }

                for(int j=1; j<=2*n-2*i; j++){
                    System.out.print(" ");
                }

                for(int k=1; k<=i; k++){
                    System.out.print("*");
                }
            }
            else{
                for(int k=1; k<=n-(i-n); k++){
                    System.out.print("*");
                }

                for(int j=1; j<=2*i-2*n; j++){
                    System.out.print(" ");
                }

                for(int k=1; k<=n-(i-n); k++){
                    System.out.print("*");
                }
            }



            System.out.println();
        }
    }
}