import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_13913 {

    static int N, K;
    static boolean[] visited = new boolean[100001];
    static Queue<Pos> queue = new ArrayDeque<Pos>();

    static class Pos {
        int x;
        int time;
        String history;

        public Pos(int x, int time, String history) {
            this.x = x;
            this.time = time;
            this.history = history;
        }
    }

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
            Pos answer = bfs();

            sb.append(answer.time).append("\n");
            sb.append(answer.history);
            System.out.println(sb.toString());
        }
    }

    private static Pos bfs() {

        queue.offer(new Pos(N, 0, N + " "));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Pos top = queue.poll();

            if (top.x == K) {
                return top;
            }

            // 전진
            if (top.x + 1 <= 100000 && !visited[top.x + 1]) {
                queue.offer(new Pos(top.x + 1, top.time + 1, top.history + (top.x + 1) + " "));
                visited[top.x + 1] = true;
            }

            // 후진
            if (top.x - 1 >= 0 && !visited[top.x - 1]) {
                queue.offer(new Pos(top.x - 1, top.time + 1, top.history + (top.x - 1) + " "));
                visited[top.x - 1] = true;
            }

            // 순간이동
            if (top.x * 2 <= 100000 && !visited[top.x * 2]) {
                queue.offer(new Pos(top.x * 2, top.time + 1, top.history + (top.x * 2) + " "));
                visited[top.x * 2] = true;
            }
        }

        return null;
    }
}
