
import java.util.Scanner;

/**
 * 1. N(number) : 1~N 까지의 숫자, M(pickSize) : 고르는 수열의 갯수 를 입력받는다.
 * 2. numbers[M] : 선택 된 숫자 의 배열을 만든다.
 * 3. 재귀적으로 호출을 하며 숫자를 선택한다.
 *  3-1. 기저 조건 (cnt == M) 이면 출력 후 return 한다.
 *  3-2. 재귀 호출 시 다음 인덱스를 호출하여 오름차순으로 진행되게 한다.
 */

public class Main {

    static int number, pickSize;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //  1. N(number) : 1~N 까지의 숫자, M(pickSize) : 고르는 수열의 갯수 를 입력받는다.
        number = sc.nextInt();
        pickSize = sc.nextInt();

        // 2. numbers[M] : 선택 된 숫자 의 배열을 만든다.
        numbers =  new int[pickSize];

        // 3. 재귀적으로 호출을 하며 숫자를 선택한다.
        순열(1, 0);
    }

    public static void 순열(int startIdx, int cnt){
        // 3-1. 기저 조건 (cnt == M) 이면 출력 후 return 한다.
        if(cnt == pickSize){
            for(int num : numbers){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int idx=startIdx; idx<=number; idx++){
            // 3-2. 재귀 호출 시 다음 인덱스를 호출하여 오름차순으로 진행되게 한다.
            numbers[cnt] = idx;
            순열(idx+1, cnt+1);
        }
    }
}
