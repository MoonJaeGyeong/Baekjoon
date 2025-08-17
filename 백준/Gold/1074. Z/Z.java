
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = calcIndex(N, r, c);
        System.out.println(result);
    }
    
    private static int calcIndex(int N, int row, int col) {
        int index = 0;
        int size = 1 << N; // 2^N

        for (int level = N; level > 0; level--) {
            size >>= 1; // 사분면 한 변 크기
            int quadrant = 0;

            if (row >= size) { // 아래쪽
                quadrant += 2;
                row -= size;
            }
            if (col >= size) { // 오른쪽
                quadrant += 1;
                col -= size;
            }

            // 사분면 번호에 따른 오프셋 더하기
            index += quadrant * size * size;
        }
        return index;
    }
}