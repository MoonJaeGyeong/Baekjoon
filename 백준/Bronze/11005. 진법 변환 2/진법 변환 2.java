import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int formation = scanner.nextInt();
        List<String> text = new ArrayList<>();
        int i = 1;
        int prev = 0;
        int v = 0;
        int input;
        
        do {
            v = sum % (int) Math.pow(formation, i);

            if(text.isEmpty()){
               text.add(String.valueOf(v));
               prev = v;
            } else{
                input = (v - prev) / (int) Math.pow(formation, i-1);
                text.add(String.valueOf(input));
            }


            i++;
        } while (v != sum);

        for(int index=text.size()-1; index >=0; index--){
            String s = text.get(index);
            if(s.length() > 1){
                char c = (char) (Integer.parseInt(s) + 55);
                System.out.print(c);
            } else {
                System.out.print(s);
            }
        }


        
        
        

    }

}
