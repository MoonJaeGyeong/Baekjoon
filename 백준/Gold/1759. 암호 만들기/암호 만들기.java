import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int L;
    static int C;
    static char[] alpha;
    static boolean[] select;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        alpha = new char[C];
        select = new boolean[C];

        for(int i=0; i<C; i++){
            alpha[i] = sc.next().charAt(0);
        }

        Arrays.sort(alpha);
        makePassword(0,0);
    }

    static void makePassword(int idx, int cnt){
        if(cnt == L){
            int consonant = 0;
            int vowel = 0;

            for(int i=0; i<C; i++){
                if(select[i]){
                    switch (alpha[i]){
                        case 'a': case 'e': case'i': case 'o': case'u':
                            consonant++;
                            break;
                        default:
                            vowel++;
                            break;
                    }
                }
            }

            if(consonant > 0 && vowel > 1){
                for(int i=0; i<C; i++){
                    if(select[i]){
                        System.out.print(alpha[i]);
                    }
                }
                System.out.println();
            }
            return;
        }

        if(idx == C) return;

        select[idx] = true;
        makePassword(idx+1, cnt+1);
        select[idx] = false;
        makePassword(idx+1, cnt);

    }
}