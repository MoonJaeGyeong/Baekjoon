
import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[][] room;
    static int[] pathLen;       // 각 방 번호에서 시작했을 때 경로 길이
    static int maxLen, startNum;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            room = new int[N][N];
            pathLen = new int[N * N + 1]; // 방 번호 1~N*N

            // 좌표 매핑: idx = 방 번호, value = (row*N + col)
            int[] pos = new int[N * N + 1];

            for (int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    room[r][c] = Integer.parseInt(st.nextToken());
                    pos[room[r][c]] = r * N + c;
                }
            }

            maxLen = 0;
            startNum = 0;

            // 큰 방 번호에서 시작해서 작은 번호 쪽으로 역방향 길이 채우기
            for (int num = N * N; num >= 1; num--) {
                if (pathLen[num] == 0) {
                    pathLen[num] = computeLength(num, pos);
                }
                if (pathLen[num] > maxLen ||
                        (pathLen[num] == maxLen && num < startNum)) {
                    maxLen = pathLen[num];
                    startNum = num;
                }
            }

            sb.append('#').append(tc).append(' ')
                    .append(startNum).append(' ').append(maxLen).append('\n');
        }
        System.out.print(sb);
    }

    // 현재 방 번호 num에서 출발했을 때의 이동 가능 길이
    private static int computeLength(int num, int[] pos) {
        int idx = pos[num];
        int r = idx / N;
        int c = idx % N;

        // 상하좌우 중 번호가 +1인 방으로 이동
        for (int d = 0; d < 4; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (room[nr][nc] == num + 1) {
                // 다음 방 번호의 길이가 이미 계산되어 있으면 재사용
                pathLen[num] = 1 + (pathLen[num + 1] != 0 ? pathLen[num + 1]
                        : computeLength(num + 1, pos));
                return pathLen[num];
            }
        }
        // 더 이동할 곳이 없으면 자기 자신만 포함
        return pathLen[num] = 1;
    }
}