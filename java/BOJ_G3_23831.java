import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_23831 {

    static int N, A, B;
    static int[][] point;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        point = new int[N][4];
        dp = new int[N][N][N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                point[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        System.out.println(recur(0, 0, 0, 0));
    }

    private static int recur(int cur, int a, int b, int c) {

        if (cur == N) {
            if (b >= B) return 0;
            return Integer.MIN_VALUE;
        }

        if (dp[cur][a][b][c] != -1) return dp[cur][a][b][c];

        int max = Integer.MIN_VALUE;

        max = Math.max(max, recur(cur + 1, a, b + 1, 0) + Math.max(point[cur][0], point[cur][1]));
        if (c == 0) max = Math.max(max, recur(cur + 1, a, b, 1) + point[cur][2]);
        if (a < A) max = Math.max(max, recur(cur + 1, a + 1, b, 0) + point[cur][3]);

        dp[cur][a][b][c] = max;
        return dp[cur][a][b][c];
    }
}
