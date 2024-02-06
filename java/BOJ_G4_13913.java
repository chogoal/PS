import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_13913 {

    static int N, K;
    static int[] time = new int[100001];
    static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < N) { // 동생이 수빈이보다 뒤에 있다면
            sb.append(N - K).append("\n");
            for (int i = N; i >= K; i--) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString());
        } else {
            bfs();

            Stack<Integer> stack = new Stack<>();
            stack.push(K);
            int prev = K;

            while (prev != N) {
                stack.push(parent[prev]);
                prev = parent[prev];
            }

            sb.append(time[K] - 1).append("\n");
            while (!stack.empty()) {
                sb.append(stack.pop() + " ");
            }
            System.out.println(sb.toString());
        }
    }

    private static void bfs() {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        time[N] = 1;

        while (!queue.isEmpty()) {

            int top = queue.poll();

            if (top == K) {
                return;
            }

            // 전진
            if (top + 1 <= 100000 && time[top + 1] == 0) {
                queue.offer(top + 1);
                time[top + 1] = time[top] + 1;
                parent[top + 1] = top;
            }

            // 후진
            if (top - 1 >= 0 && time[top - 1] == 0) {
                queue.offer(top - 1);
                time[top - 1] = time[top] + 1;
                parent[top - 1] = top;
            }

            // 순간이동
            if (top * 2 <= 100000 && time[top * 2] == 0) {
                queue.offer(top * 2);
                time[top * 2] = time[top] + 1;
                parent[top * 2] = top;
            }
        }
    }
}
