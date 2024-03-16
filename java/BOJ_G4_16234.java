import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_16234 {

    static int N, L, R;
    static int[][] country;
    static boolean[][] visited;
    static int uniteSum;
    static Queue<int[]> unite;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        country = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            if (open()) break;
            day++;
        }

        System.out.println(day);
    }

    private static boolean open() {

        visited = new boolean[N][N];

        // 조건을 만족하는 모든 국경선 오픈
        boolean isMoved = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    // 초기화
                    uniteSum = 0;
                    unite = new ArrayDeque<int[]>();

                    bfs(i, j);

                    // 인구 이동
                    if (unite.size() > 1) {
                        isMoved = true;
                        move(uniteSum / unite.size());
                    }
                }
            }
        }

        // 인구 이동이 없었다면, 반복 종료
        return !isMoved;
    }

    private static void move(int average) {

        while (!unite.isEmpty()) {
            int[] u = unite.poll();
            country[u[0]][u[1]] = average;
        }
    }

    private static void bfs(int i, int j) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { i, j });
        visited[i][j] = true;

        uniteSum = country[i][j]; // 연합 인구 수
        unite.offer(new int[] { i, j });

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                int diff = Math.abs(country[cur[0]][cur[1]] - country[nx][ny]);
                if (diff >= L && diff <= R) {
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                    uniteSum += country[nx][ny];
                    unite.offer(new int[] { nx, ny });
                }
            }
        }
    }
}
