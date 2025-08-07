import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    // 1. 회의의 시작과 끝을 입력 받음
    // 2. 회의가 끝나는 시간 기준 정렬
    // 3. 순서대로 꺼낸 뒤 끝난 시간이 시작 시간 보다 크거나 같다면 회의실 배정


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 10만개 가능
        int answer = 0;
        PriorityQueue<Meeting> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startT = Integer.parseInt(st.nextToken());
            int endT = Integer.parseInt(st.nextToken());
            Meeting m = new Meeting(startT, endT);
            pq.add(m);
        }

        int curT = pq.poll().endT; // 제일 빨리 끝나는 회의 하나 꺼내기
        answer++;

        while(!pq.isEmpty()){
            // 3. 순서대로 꺼낸 뒤 끝난 시간이 시작 시간 보다 크거나 같다면 회의실 배정
            Meeting meeting = pq.poll();

            if(meeting.startT >= curT){
                curT = meeting.endT; // 현재 시간 업데이트
                answer++;
            }
        }

        System.out.println(answer);
    }

}

class Meeting implements Comparable{

    int startT;
    int endT;

    public Meeting(int startT, int endT) {
        this.startT = startT;
        this.endT = endT;
    }

    public int compareTo(Object o) {
        Meeting m = (Meeting)o;

        if(this.endT == m.endT) {
            return this.startT - m.startT;
        }
        return this.endT - m.endT;
    }
}