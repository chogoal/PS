import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_1149 {

    static int N;
    static int[][] cost, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][4];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(recur(0, 0));
    }

    private static int recur(int cur, int prev) {

        if (cur == N) return 0;

        if (dp[cur][prev] != 0) return dp[cur][prev];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
            if (prev == i) continue;
            min = Math.min(min, recur(cur + 1, i) + cost[cur][i - 1]);
        }

        dp[cur][prev] = min;
        return dp[cur][prev];
    }
}
