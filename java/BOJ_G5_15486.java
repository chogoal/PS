import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_15486 {

    static int N;
    static int[] T, P, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        dp = new int[N + 51];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        dp[N] = 0;
        for (int i = N - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + T[i]] + P[i], dp[i + 1]);
        }

        System.out.println(dp[0]);
    }

//    private static int recur(int t) {
//
//        if (t > N) return Integer.MIN_VALUE;
//        if (t == N) return 0;
//
//        if (dp[t] == 0) dp[t] = Math.max(recur(t + T[t]) + P[t], recur(t + 1));
//        return dp[t];
//    }
}
