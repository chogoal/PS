import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_17144 {

    static int R, C, T;
    static int[][] house;
    static int[] cleaner = new int[2];
    static int[] dx = { 0, 1, 0,- 1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        house = new int[R][C];

        int cleanerIdx = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());

                if (house[i][j] == -1) {
                    cleaner[cleanerIdx++] = i;
                }
            }
        }

        while (T-- > 0) {
            bfs();
            cleaner();
        }

        System.out.println(dust());
    }

    private static void bfs() {

        Queue<int[]> queue = new ArrayDeque<int[]>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (house[i][j] > 0) {
                    int spread = house[i][j] / 5;

                    int cnt = 0; // 확산된 방향의 개수
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || nx >= R || ny < 0 || ny >= C || house[nx][ny] == -1) continue;

                        cnt++;
                        queue.offer(new int[] { nx, ny, spread });
                    }

                    int remain = -(spread * cnt);
                    queue.offer(new int[] { i, j, remain });
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            house[top[0]][top[1]] += top[2];
        }
    }

    private static void cleaner() {

        int upX = cleaner[0];
        int downX = cleaner[1];

        // 위쪽 공기청정기 바람
        for (int i = upX - 1; i > 0; i--) {
            house[i][0] = house[i - 1][0];
        }

        for (int j = 0; j < C - 1; j++) {
            house[0][j] = house[0][j + 1];
        }

        for (int i = 0; i < upX; i++) {
            house[i][C- 1] = house[i + 1][C - 1];
        }

        for (int j = C - 1; j > 1; j--) {
            house[upX][j] = house[upX][j - 1];
        }
        house[upX][1] = 0;

        // 아래쪽 공기청정기 바람
        for (int i = downX + 1; i < R - 1; i++) {
            house[i][0] = house[i + 1][0];
        }

        for (int j = 0; j < C - 1; j++) {
            house[R - 1][j] = house[R - 1][j + 1];
        }

        for (int i = R - 1; i > downX; i--) {
            house[i][C - 1] = house[i - 1][C - 1];
        }

        for (int j = C - 1; j > 1; j--) {
            house[downX][j] = house[downX][j - 1];
        }
        house[downX][1] = 0;
    }

    private static int dust() {

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (house[i][j] == -1) continue;
                sum += house[i][j];
            }
        }

        return sum;
    }
}
