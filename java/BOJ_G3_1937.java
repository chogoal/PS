import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_1937 {

    static int n;
    static int[][] map, dp;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, eat(i, j, map[i][j]));
            }
        }

        System.out.println(max);
    }

    private static int eat(int x, int y, int cnt) {

        if (dp[x][y] != 1) return dp[x][y];

        int moved = 1;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (map[nx][ny] > cnt) {
                moved = Math.max(moved, eat(nx, ny, map[nx][ny]) + 1);
            }
        }

        dp[x][y] = moved;
        return dp[x][y];
    }
}
