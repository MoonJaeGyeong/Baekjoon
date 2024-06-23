import java.math.BigInteger;
import java.util.*;

class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger value = new BigInteger("2");
        value = value.pow(n - 1);
        value = value.divide(new BigInteger("3")).add(n % 2 == 0 ?
                new BigInteger("1") : new BigInteger("0")
        );

        System.out.println(value);



    }
}