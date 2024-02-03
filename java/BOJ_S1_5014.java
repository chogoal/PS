import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_5014 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] stairs = new int[F + 1];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(S);
        stairs[0] = -1;
        stairs[S] = -1; // 방문체크

        int count = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {
                int now = queue.poll();

                if (now == G) {
                    System.out.println(count);
                    return;
                }

                if (now - D >= 0 && stairs[now - D] != -1) {
                    queue.offer(now - D);
                    stairs[now - D] = -1;
                }
                if (now + U <= F && stairs[now + U] != -1) {
                    queue.offer(now + U);
                    stairs[now + U] = -1;
                }
            }

            count++;
        }

        System.out.println("use the stairs");
    }
}
