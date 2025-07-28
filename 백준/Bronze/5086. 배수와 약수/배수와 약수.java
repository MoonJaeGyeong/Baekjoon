import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String answer = "";
        
        while(true) {
        int first = sc.nextInt();
        int second = sc.nextInt();
        if(first == 0 && second == 0) break;
        if(first == 0 || second == 0){
            System.out.println("neither");
            continue;
        }
        if(first % second == 0){
             answer = "multiple";
        }
            
        else if(second % first == 0){
             answer = "factor";
        }        
               
        else {
            answer = "neither";
        }
            
        
         
        System.out.println(answer);
        }
    }
}