import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        String[] arr = new String[5];
        int length = 0;

        for(int i=0; i<5; i++){
            arr[i] = scanner.next();
            if(length < arr[i].length()){
                length = arr[i].length();
            }
        }

        String[] arr_2 = new String[length];

        for(int i=0; i<arr_2.length; i++){
            arr_2[i] = "";
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<arr[i].length(); j++){
                arr_2[j] += arr[i].substring(j,j+1);
            }
        }

        for(int i=0; i< arr_2.length; i++){
            answer += arr_2[i];
        }

        System.out.println(answer);
    }
}
