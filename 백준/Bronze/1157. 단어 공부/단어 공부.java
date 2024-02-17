import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int max = -1;
        int index = 0;
        boolean check = true;

        int[] wordFrequency = new int[28];
        word = word.toUpperCase();

        for(int i=0; i<word.length(); i++){
            int alphaIndex = word.charAt(i) - 65;
            wordFrequency[alphaIndex]++;

            if(max < wordFrequency[alphaIndex]){
                max = wordFrequency[alphaIndex];
                index = alphaIndex;
            }
        }

        for(int i=0; i<wordFrequency.length; i++){
            if(i != index && max == wordFrequency[i]){
                System.out.println("?");
                check = false;
                break;
            }

        }

        if(check){
            System.out.println((char) (65+index) );
        }
    }
}
