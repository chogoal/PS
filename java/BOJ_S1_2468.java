import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_2468 {

    static int N;
    static int[][] region;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        region = new int[N][N];

        int min = 0;
        int max = 101;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, region[i][j]);
                max = Math.max(max, region[i][j]);
            }
        }

        int maxCount = 0;
        for (int i = max; i >= min; i--) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (region[j][k] >= i) {
                        bfs(j, k, i);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }

    private static void bfs(int i, int j, int h) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { i, j });
        region[i][j] = h - 1;

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };

        while (!queue.isEmpty()) {
            int[] top = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = top[0] + dx[d];
                int ny = top[1] + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && region[nx][ny] >= h) {
                    queue.offer(new int[] { nx, ny });
                    region[nx][ny] = h - 1;
                }
            }
        }

    }
}
