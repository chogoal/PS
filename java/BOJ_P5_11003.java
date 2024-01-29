import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_P5_11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = i;
        }

        int[] dArray = new int[N];
        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {

            while (!deque.isEmpty()) {
                if (deque.peekLast()[0] <= array[i][0]) break;
                else deque.pollLast();
            }

            deque.offerLast(array[i]);

            // deque의 첫번째 인덱스와 새로 들어간 인덱스의 차가 L보다 크면 poll
            while (array[i][1] - deque.peek()[1] >= L) {
                deque.poll();
            }

            dArray[i] = deque.peek()[0];
        }

        for (int i = 0; i < N; i++) {
            sb.append(dArray[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
