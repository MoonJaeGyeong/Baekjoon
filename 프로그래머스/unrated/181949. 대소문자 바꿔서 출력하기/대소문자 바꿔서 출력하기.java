import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String answer = "";
        for(int i=0; i<s1.length(); i++){
            char str = s1.charAt(i);
            if(str < 91)
                answer += s1.substring(i,i+1).toLowerCase();
            else
                answer += s1.substring(i,i+1).toUpperCase();
        }
        System.out.println(answer);
    }
        
}