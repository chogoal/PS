import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_1520 {

    static int M, N;
    static int[][] map, dp;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(move(0, 0, map[0][0]));
    }

    private static int move(int x, int y, int h) {

        if (x == M - 1 && y == N - 1) return 1;

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            if (map[nx][ny] < h) {
                dp[x][y] += move(nx, ny, map[nx][ny]);
            }
        }

        return dp[x][y];
    }
}
