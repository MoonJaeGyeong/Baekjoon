import java.util.*;

class Main {
    static int n;
    static int m;
    static boolean[] visited;
    static List<Integer> rs = new ArrayList<>();


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n+1];
        method(0);
    }

    static void method(int number){
        if(number == m){
            for(int element : rs){
                System.out.print(element + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<n+1; i++){
            if(!visited[i]){
                rs.add(i);
                visited[i] = true;
                method(number+1);

                rs.remove(rs.size()-1);
                visited[i] = false;
            }

        }
    }
}