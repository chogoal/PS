import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1926 {

    static int n;
    static int m;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int count = 0, area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1) {
                    area = bfs(i, j);
                    count++;
                    max = Math.max(area, max);
                }
            }
        }

        sb.append(count).append("\n").append(max);
        System.out.println(sb.toString());
    }

    private static int bfs(int i, int j) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { i, j });
        paper[i][j] = -1;

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };

        int area = 1; // 넓이

        while (!queue.isEmpty()) {
            int[] top = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nextX = top[0] + dx[d];
                int nextY = top[1] + dy[d];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && paper[nextX][nextY] == 1) {
                    queue.offer(new int[] { nextX, nextY });
                    paper[nextX][nextY] = -1;
                    area++;
                };
            }
        }

        return area;
    }
}
