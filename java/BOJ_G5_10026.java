import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_G5_10026 {

    static int N;
    static char[][] area;
    static char[][] rgArea;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        area = new char[N][N];
        rgArea = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                area[i][j] = s.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] != '*') {
                    bfs(i, j);
                    count++;
                }
            }
        }

        int rgCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (rgArea[i][j] != '*') {
                    rgBfs(i, j);
                    rgCount++;
                }
            }
        }

        sb.append(count).append(" ").append(rgCount);
        System.out.println(sb.toString());
    }

    private static void bfs(int i, int j) {

        char rgb = area[i][j];
        rgArea[i][j] = rgb == 'G' ? 'R' : rgb;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { i, j });
        area[i][j] = '*';

        while (!queue.isEmpty()) {
            int[] top = queue.poll();

            int[] dx = { 0, 1, 0, -1 };
            int[] dy = { 1, 0, -1, 0 };

            for (int d = 0; d < 4; d++) {
                int nextX = top[0] + dx[d];
                int nextY = top[1] + dy[d];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && area[nextX][nextY] == rgb) {
                    queue.offer(new int[] { nextX, nextY });
                    rgArea[nextX][nextY] = rgb == 'G' ? 'R' : rgb;
                    area[nextX][nextY] = '*';
                }
            }
        }

    }

    private static void rgBfs(int i, int j) {

        char rgb = rgArea[i][j];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { i, j });
        rgArea[i][j] = '*';

        while (!queue.isEmpty()) {
            int[] top = queue.poll();

            int[] dx = { 0, 1, 0, -1 };
            int[] dy = { 1, 0, -1, 0 };

            for (int d = 0; d < 4; d++) {
                int nextX = top[0] + dx[d];
                int nextY = top[1] + dy[d];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && rgArea[nextX][nextY] == rgb) {
                    queue.offer(new int[] { nextX, nextY });
                    rgArea[nextX][nextY] = '*';
                }
            }
        }

    }
}
