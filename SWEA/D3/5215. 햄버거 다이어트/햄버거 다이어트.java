import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 5215 햄버거 다이어트 변형 코드
 * 
 * 주어진 재료 조합 중 칼로리 제한을 넘지 않으면서
 * 가장 높은 맛 점수를 구하는 문제.
 */
public class Solution {

    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static StringBuilder output;

    static int T; // 테스트 케이스 수
    static int N, limit; // 재료 개수, 칼로리 제한
    static int[][] ingredients; // [점수, 칼로리]
    static int[][] pickBuffer;  // 선택된 재료 저장용
    static int maxTaste;        // 최대 맛 점수

    static final int TASTE = 0;
    static final int CAL = 1;

    static void choose(int idx, int picked) {
        // 모든 선택 완료 시
        if (picked == pickBuffer.length) {
            int tasteSum = 0, calSum = 0;
            for (int[] item : pickBuffer) {
                tasteSum += item[TASTE];
                calSum += item[CAL];
            }
            if (calSum <= limit && tasteSum > maxTaste) {
                maxTaste = tasteSum;
            }
            return;
        }

        // 더 이상 선택할 재료가 없는 경우
        if (idx == N) return;

        // 현재 재료 선택
        pickBuffer[picked][TASTE] = ingredients[idx][TASTE];
        pickBuffer[picked][CAL] = ingredients[idx][CAL];
        choose(idx + 1, picked + 1);

        // 현재 재료 미선택
        choose(idx + 1, picked);
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();

        T = Integer.parseInt(reader.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            limit = Integer.parseInt(tokenizer.nextToken());

            ingredients = new int[N][2];
            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                ingredients[i][TASTE] = Integer.parseInt(tokenizer.nextToken());
                ingredients[i][CAL] = Integer.parseInt(tokenizer.nextToken());
            }

            maxTaste = 0;
            // 1개 이상 N개 이하의 재료 조합
            for (int cnt = 1; cnt <= N; cnt++) {
                pickBuffer = new int[cnt][2];
                choose(0, 0);
            }

            output.append('#').append(tc).append(' ').append(maxTaste).append('\n');
        }
        System.out.print(output);
    }
}
