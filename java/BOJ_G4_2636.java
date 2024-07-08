import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_2636 {

    static int R, C;
    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int cheese;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheese++;
            }
        }

        int time = 0;
        int remain = cheese;

        while (cheese > 0) {
            time++;
            remain = cheese;
            bfs();
        }

        sb.append(time).append("\n").append(remain);
        System.out.println(sb.toString());
    }

    private static void bfs() {

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        queue.offer(new int[] { 0, 0 });
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                } else if (map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = 0;
                    cheese--;
                }
            }
        }
    }
}
