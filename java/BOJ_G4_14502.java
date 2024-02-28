import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_14502 {

    static int N, M;
    static int[][] map; // 0: 빈 칸, 1: 벽, 2: 바이러스
    static int max = Integer.MIN_VALUE;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(max);
    }

    private static void dfs(int cnt) {

        if (cnt == 3) {
            max = Math.max(max, bfs());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int bfs() {

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[][] virus = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                    virus[i][j] = 2;
                } else if (map[i][j] == 1) virus[i][j] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                    virus[nx][ny] = 2;
                }
            }
        }

        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus[i][j] == 0) safeZone++;
            }
        }

        return safeZone;
    }
}
