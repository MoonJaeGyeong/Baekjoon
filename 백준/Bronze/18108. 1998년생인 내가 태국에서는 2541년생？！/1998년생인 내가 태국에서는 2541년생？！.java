import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = solution(sc.nextInt());


        System.out.println(year);
    }

    public static int solution(int year){
        return year - 543;
    }
}