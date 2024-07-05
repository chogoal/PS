import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1697 {

    static int N, K;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        System.out.println(bfs());
    }

    private static int bfs() {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                return visited[K] - 1;
            }

            if (now + 1 <= 100000 && visited[now + 1] == 0) {
                queue.offer(now + 1);
                visited[now + 1] = visited[now] + 1;
            }

            if (now - 1 >= 0 && visited[now - 1] == 0) {
                queue.offer(now - 1);
                visited[now - 1] = visited[now] + 1;
            }
            if (now * 2 <= 100000 && visited[now * 2] == 0) {
                queue.offer(now * 2);
                visited[now * 2] = visited[now] + 1;
            }
        }

        return -1;
    }
}
