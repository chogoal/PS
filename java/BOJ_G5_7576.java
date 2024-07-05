import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_7576 {

    static int M, N;
    static int[][] map;
    static int green;
    static Queue<int[]> queue;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != -1) {
                    if (map[i][j] == 0) green++;
                    if (map[i][j] == 1) queue.offer(new int[] { i, j });
                }
            }
        }

        if (green == 0) System.out.println(0);
        else System.out.println(bfs());
    }

    private static int bfs() {

        int day = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] now = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0) continue;

                    queue.offer(new int[] { nx, ny });
                    map[nx][ny] = 1;
                    green--;
                }
            }

            day++;
            if (green == 0) return day;
        }

        return -1;
    }
}
