import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G3_20058 {

    static int n, N, Q;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        N = (int)Math.pow(2, n);
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int q = 0; q < Q; q++) {
            int L = Integer.parseInt(st.nextToken());

            firestorm(L);
        }

        int sum = 0;
        int max = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;
                sum += map[i][j];
                if (!visited[i][j]) max = Math.max(max, bfs(i, j));
            }
        }

        sb.append(sum).append("\n").append(max);
        System.out.println(sb.toString());
    }

    private static void firestorm(int l) {

        int[][] mapCopy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mapCopy[i][j] = map[i][j];
            }
        }

        int size = (int) Math.pow(2, l);
        for (int i = 0; i < N; i += size) {
            for (int j = 0; j < N; j += size) {
                // 부분 격자 회전
                for (int r = 0; r < size; r++) {
                    for (int c = 0; c < size; c++) {
                        mapCopy[i + c][j + (size - 1 - r)] = map[i + r][j + c];
                    }
                }
            }
        }

        List<int[]> melt = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mapCopy[i][j] == 0) continue;

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (mapCopy[nx][ny] > 0) cnt++;
                }

                if (cnt < 3) melt.add(new int[] { i, j });
            }
        }

        for (int[] pos : melt) {
            mapCopy[pos[0]][pos[1]]--;
        }

        map = mapCopy;
    }

    private static int bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        visited[x][y] = true;

        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                if (map[nx][ny] > 0) {
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
