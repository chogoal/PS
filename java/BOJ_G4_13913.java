import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_G4_13913 {

    static int N, K;
    static boolean[] visited;
    static int[] before; // 이전 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        before = new int[100001];

        bfs();

        int next = K;
        Stack<Integer> stack = new Stack<>();
        while (next != N) {
            stack.push(next);
            next = before[next];
        }

        sb.append(stack.size()).append("\n");
        sb.append(N).append(" ");
        while (!stack.empty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void bfs() {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        visited[N] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) return;

            if (now + 1 <= 100000 && !visited[now + 1]) {
                queue.offer(now + 1);
                visited[now + 1] = true;
                before[now + 1] = now;
            }

            if (now - 1 >= 0 && !visited[now - 1]) {
                queue.offer(now - 1);
                visited[now - 1] = true;
                before[now - 1] = now;
            }

            if (now * 2 <= 100000 && !visited[now * 2]) {
                queue.offer(now * 2);
                visited[now * 2] = true;
                before[now * 2] = now;
            }
        }
    }
}
