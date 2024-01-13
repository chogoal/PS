import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        visited[N] = 1;

        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(N);

        int time = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                time = visited[cur] - 1;
                break;
            }

            if (cur - 1 >= 0 && visited[cur - 1] == 0) {
                visited[cur - 1] = visited[cur] + 1;
                queue.offer(cur - 1);
            }
            if (cur + 1 <= 100000 && visited[cur + 1] == 0) {
                visited[cur + 1] = visited[cur] + 1;
                queue.offer(cur + 1);
            }
            if (cur * 2 <= 100000 && visited[cur * 2] == 0) {
                visited[cur * 2] = visited[cur] + 1;
                queue.offer(cur * 2);
            }
        }

        System.out.println(time);
    }
}
