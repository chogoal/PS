import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_14502 {

    static int N, M;
    static int[][] map; // 0: 빈 칸, 1: 벽, 2: 바이러스
    static ArrayList<int[]> zero = new ArrayList<int[]>();

    static int virus;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int max = Integer.MIN_VALUE;

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

                if (map[i][j] == 0) zero.add(new int[] { i, j });
            }
        }

        dfs(0, 0);

        System.out.println(max - 3);
    }

    private static void dfs(int cnt, int start) {

        if (cnt == 3) {

            virus = 0;
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 2) {
                        bfs(i, j);
                    }
                }
            }

            max = Math.max(max, zero.size() - virus);

            return;
        }

        for (int i = start; i < zero.size(); i++) {
            int[] pos = zero.get(i);

            if (map[pos[0]][pos[1]] == 0) {
                map[pos[0]][pos[1]] = 1;
                dfs(cnt + 1, i + 1);
                map[pos[0]][pos[1]] = 0;
            }
        }
    }

    private static void bfs(int i, int j) {

        Queue<int[]> queue = new ArrayDeque<>();

        if (!visited[i][j]) {
            queue.offer(new int[] { i, j });
            visited[i][j] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

                    if (map[nx][ny] == 0) {
                        queue.offer(new int[] { nx, ny });
                        visited[nx][ny] = true;
                        virus++;
                    }
                }
            }
        }
    }
}
