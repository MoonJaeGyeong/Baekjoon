import java.util.*;

class Main {
    static int n;
    static int m;
    static List<Integer> numbers = new ArrayList<>();
    static List<Integer> select_numbers = new ArrayList<>();
    static int sum = 0;
    static int result = 0;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0; i<n; i++){
            numbers.add(sc.nextInt());
        }

        method(0);
        System.out.println(result);
    }

    static void method(int number){
        if(!select_numbers.isEmpty() && sum == m){
           result++;
        }

        for(int i=number; i<n; i++){
            select_numbers.add(numbers.get(i));
            sum += numbers.get(i);
            method(i+1);

            sum -= select_numbers.get(select_numbers.size()-1);
            select_numbers.remove(select_numbers.size()-1);
        }
    }
}