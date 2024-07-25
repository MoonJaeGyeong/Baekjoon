import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] max_arr = new int[3];

        int max = -1;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }


        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    int sum = arr[i] + arr[j] + arr[k];

                    if(max < sum && sum <= m){
                        max = sum;
                        max_arr[0] = arr[i];
                        max_arr[1] = arr[j];
                        max_arr[2] = arr[k];

                    }
                }
            }
        }

        System.out.println(max);
    }
}