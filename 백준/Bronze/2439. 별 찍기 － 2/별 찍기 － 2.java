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
            for(int j=i; j<n; j++)
              bw.write(" ");

            for(int k=0; k<i; k++)
                bw.write("*");

            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
