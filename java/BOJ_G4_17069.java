import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_17069 {

    static int N;
    static int[][] map;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pipe();

        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
    }

    private static void pipe() {

        dp[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (map[i][j] == 1) continue;

                // 오른쪽 이동
                if (j > 0) {
                    dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
                }

                // 아래쪽 이동
                if (i > 0) {
                    dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
                }

                // 대각선 이동
                if (i > 0 && j > 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                    dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }
    }
}
