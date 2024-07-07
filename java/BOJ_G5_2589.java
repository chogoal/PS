import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_2589 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                map[i][j] = c == 'W' ? 0 : 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }

        System.out.println(ans);
    }

    private static int bfs(int x, int y) {

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] check = new boolean[N][M];
        queue.offer(new int[] { x, y, 0 });
        check[x][y] = true;

        int max = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            max = Math.max(max, now[2]);

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == 0 || check[nx][ny] || visited[nx][ny]) continue;

                queue.offer(new int[] { nx, ny, now[2] + 1 });
                check[nx][ny] = true;
            }
        }

        return max;
    }
}
