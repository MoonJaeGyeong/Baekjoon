import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /**
     *
     * @param args
     * 1. 지름길의 개수 shortcuts <= 12 개, 길이 distance <= 1만 입력받음
     * 2. distance 만큼 도로(road) 1차원 배열 만든 후 idx 마다 값을 초기화
     * 3. shortcuts 번만큼 반복하며 시작 위치(startPos), 도착 위치(endPos), 지름길(shortcut)을 입력 받음
     *  3-1. if 스타트 위치(startIdx) 의 값 + 지름길 값 < 도착 위치(endIdx) 의 값 이면
     *      3-1-1. 도착위치의 값을 더 작은(min) 값으로 교체
     *      3-1-2. 도착 위치 이후의 값을 전 idx 의 값에 +1 하는 방식으로 배열 재초기화
     * 4. 마지막 값 출력
     */

    static BufferedReader br;
    static StringTokenizer st;
    static int shortcuts;
    static int distance;
    static int[] road;

    public static void main(String[] args)  throws IOException {
        // 1. 지름길의 개수 shortcuts <= 12 개, 길이 distance <= 1만 입력받음
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        List<Shortcut> list = new ArrayList<>();

        shortcuts = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());

        road = new int[distance+1];

        //  2. distance 만큼 도로(road) 1차원 배열 만든 후 idx 마다 값을 초기화
        for(int idx=0; idx<=distance; idx++){
            road[idx] = idx;
        }

        // 3. shortcuts 번만큼 반복하며 시작 위치(startPos), 도착 위치(endPos), 지름길(shortcut)을 입력 받음
        for(int i=0; i<shortcuts; i++){
            st = new StringTokenizer(br.readLine());

            int startPos = Integer.parseInt(st.nextToken());
            int endPos = Integer.parseInt(st.nextToken());
            int shortcut = Integer.parseInt(st.nextToken());

            Shortcut s = new Shortcut(startPos, endPos, shortcut);
            list.add(s);
        }

        for(int idx=1; idx<=distance; idx++){
            road[idx] = Math.min(road[idx], road[idx - 1] + 1);

            for(int shortIdx=0; shortIdx<shortcuts; shortIdx++){
                Shortcut s = list.get(shortIdx);

                int startPos = s.start;
                int endPos = s.end;
                int shortcut = s.shortcut;


                if(endPos == idx){
                    //  3-1. if 스타트 위치(startIdx) 의 값 + 지름길 값 < 도착 위치(endIdx) 의 값 이면
                    // 3-1-1. 도착위치의 값을 더 작은(min) 값으로 교체
                    road[endPos] = Math.min(road[endPos], road[startPos] + shortcut);
                }
            }
        }


        //  4. 마지막 값 출력
        System.out.println(road[distance]);

    }

}

class Shortcut {

    int start;
    int end;
    int shortcut;

    Shortcut(int start, int end, int shortcut){
        this.start = start;
        this.end = end;
        this.shortcut = shortcut;
    }

}

