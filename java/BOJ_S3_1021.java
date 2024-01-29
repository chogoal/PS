import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_S3_1021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < M; i++) {
            int index = Integer.parseInt(st.nextToken());

            int count = 0;
            while (deque.peekFirst() != index) { // 왼쪽 이동
                count++;
                deque.offerLast(deque.pollFirst());
            }

            if (count > deque.size() / 2) {
                while (deque.peekLast() != index) {
                    count--;
                    deque.offerFirst(deque.pollLast());
                }
                deque.pollLast();
                sum -= count - 1;
            } else {
                deque.pollFirst();
                sum += count;
            }
        }

        System.out.println(sum);
    }
}
