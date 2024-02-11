import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String spells = sc.next();
        int length = spells.length();
        int[] dial = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};

        for(int i=0; i<spells.length(); i++){
            int asc = (spells.charAt(i) - 65);
            length += dial[asc];
        }
        System.out.println(length);
    }
}
