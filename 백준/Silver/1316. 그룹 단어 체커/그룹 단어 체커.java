import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int repeat = scanner.nextInt();
        String word;
        int answer = repeat;

        for(int i=0; i<repeat; i++){
            word = scanner.next();

            for(int j=0; j<word.length(); j++){
                String spell = word.substring(j,j+1);
                int k;
                
                for(k=j+1; k<word.length(); k++){
                    if(!word.substring(k,k+1).equals(spell)){
                        break;
                    }
                }

                String word_2 = word.substring(k, word.length());

                if(word_2.contains(spell)){
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
