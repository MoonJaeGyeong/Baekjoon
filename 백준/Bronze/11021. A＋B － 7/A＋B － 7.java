import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException{
        String arr[] = new String[2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++){
                arr = br.readLine().split(" ");
                int sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
                bw.write("Case #" + i + ": " + String.valueOf(sum));
                bw.newLine();

        }
        bw.flush();
        bw.close();
    }



}
