import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_1261 {

    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0, 0, 0 });
        visited[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int broken = cur[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 방문한 적 없는 경우
                if (visited[nx][ny] == -1) {
                    if (map[nx][ny] == 0) {
                        queue.offer(new int[] { nx, ny, broken });
                        visited[nx][ny] = broken;
                    } else {
                        queue.offer(new int[] { nx, ny, broken + 1 });
                        visited[nx][ny] = broken + 1;
                    }
                }
                // 방문한 적 있는 경우
                else {
                    if (map[nx][ny] == 0 && visited[nx][ny] > broken) {
                        queue.offer(new int[] { nx, ny, broken });
                        visited[nx][ny] = broken;
                    } else if (map[nx][ny] == 1 && visited[nx][ny] > broken + 1) {
                        queue.offer(new int[] { nx, ny, broken + 1 });
                        visited[nx][ny] = broken + 1;
                    }
                }
            }
        }

        return visited[N - 1][M - 1];
    }
}
