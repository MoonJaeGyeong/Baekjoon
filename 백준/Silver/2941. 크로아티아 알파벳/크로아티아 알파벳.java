import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int length = word.length();
        String croatia_c1 = "c=";
        String croatia_c2 = "c-";
        String croatia_dz = "dz=";
        String croatia_d = "d-";
        String croatia_lj = "lj";
        String croatia_nj = "nj";
        String croatia_s = "s=";
        String croatia_z = "z=";


        for(int i=0; i<word.length()-1; i++){
            String str = word.substring(i,i+2);
            String str_3;

            if(i<word.length()-2){
                str_3 = word.substring(i,i+3);
            }  else {
                str_3 = "";
            }


            if(str.contains(croatia_c2) || str.contains(croatia_c1) || str.contains(croatia_d) || str.contains(croatia_lj) ||
                    str.contains(croatia_nj) || str.contains(croatia_s) || str.contains(croatia_z)){
                length--;
            }

            if(str_3.equals(croatia_dz)){
                length--;
            }
        }

        System.out.println(length);
    }
}
