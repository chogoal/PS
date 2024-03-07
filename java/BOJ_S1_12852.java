import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_12852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][2]; // dp값, 이전 인덱스값
        dp[1][0] = 0; dp[1][1] = 0;

        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = dp[i - 1][0] + 1; dp[i][1] = i - 1;

            if (i % 3 == 0) {
                if (dp[i / 3][0] + 1 < dp[i][0]) {
                    dp[i][0] = dp[i / 3][0] + 1;
                    dp[i][1] = i / 3;
                }
            }
            if (i % 2 == 0) {
                if (dp[i / 2][0] + 1 < dp[i][0]) {
                    dp[i][0] = dp[i / 2][0] + 1;
                    dp[i][1] = i / 2;
                }
            }
        }

        sb.append(dp[N][0]).append("\n");

        while (N >= 1) {
            sb.append(N).append(" ");
            N = dp[N][1];
        }

        System.out.println(sb.toString());
    }
}
