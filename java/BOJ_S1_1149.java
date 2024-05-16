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
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Math.min(recur(0, 0), Math.min(recur(0, 1), recur(0, 2))));
    }

    private static int recur(int cur, int prev) {

        if (cur == N) return 0;

        if (dp[cur][prev] != 0) return dp[cur][prev];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (prev == i) continue;
            min = Math.min(min, recur(cur + 1, i) + cost[cur][i]);
        }

        dp[cur][prev] = min;
        return dp[cur][prev];
    }
}
