import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_2698 {

    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            sb.append(count()).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int count() {

        int[][][] dp = new int[n + 1][k + 1][2];

        dp[1][0][0] = 1; // 0
        dp[1][0][1] = 1; // 1

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (j > k) break;
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];

                dp[i][j][1] = dp[i - 1][j][0];
                if (j != 0) dp[i][j][1] += dp[i - 1][j - 1][1];
            }
        }

        return dp[n][k][0] + dp[n][k][1];
    }
}
