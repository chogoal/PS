import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_2573 {

    static int N, M;
    static int[][] ice;
    static int[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ice = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
ex:     while (true) {

            year++;

            int[][] melt = new int[N][M]; // 매해 녹는 얼음 양

            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        if (ice[i + dx[d]][j + dy[d]] == 0) count--;
                    }
                    melt[i][j] = count;
                }
            }

            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    ice[i][j] += melt[i][j];
                    if (ice[i][j] < 0) ice[i][j] = 0;
                }
            }

            int count = 0;
            visited = new int[N][M];
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (ice[i][j] > 0 && visited[i][j] == 0) {
                        bfs(i, j);
                        count++;
                        if (count >= 2) {
                            break ex;
                        }
                    }
                }
            }

            if (count == 0) {
                year = 0;
                break;
            }
        }

        System.out.println(year);
    }

    private static void bfs(int i, int j) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { i, j });
        visited[i][j] = -1;

        while (!queue.isEmpty()) {
            int[] top = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = top[0] + dx[d];
                int ny = top[1] + dy[d];

                if (nx >= 1 && nx < N - 1 && ny >= 1 && ny < M - 1) {
                    if (ice[nx][ny] > 0 && visited[nx][ny] == 0) {
                        queue.offer(new int[] { nx, ny });
                        visited[nx][ny] = -1;
                    }
                }
            }
        }
    }
}
