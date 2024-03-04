import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int point = scanner.nextInt();
        int x_root = 1;
        int y_root = 3;
        int x_start = 2;
        int y_start = 4;

        int answer = 2;
        String answer_root;
        int[] xy = new int[2];

        while(true){
            x_root += 4;
            y_root += 4;

            if(x_start <= point && point < y_start){
                answer_root = "x";
                break;
            }
            else if(y_start <= point && point < x_start + x_root){
                answer++;
                answer_root = "y";
                break;
            }

            x_start += x_root;
            y_start += y_root;
            answer += 2;
        }

        if(point == 1){
            System.out.println("1/1");
        }

        else{

            if(answer_root.equals("x")){
                xy[0] = 1;
                xy[1] = answer;

                for(int i=0; i<point-x_start; i++){
                    xy[0]++;
                    xy[1]--;
                }
            }

            if(answer_root.equals("y")){
                xy[1] = 1;
                xy[0] = answer;
                for(int i=0; i<point-y_start; i++){
                    xy[0]--;
                    xy[1]++;
                }
            }

            System.out.println(xy[0] + "/" + xy[1]);
        }

    }

}
