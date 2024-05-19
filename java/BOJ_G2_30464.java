import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G2_30464 {

    static int N;
    static int[] num;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        dp = new int[N][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = move(0, 0, 1);
        System.out.println(result < 0 ? -1 : result);
    }

    private static int move(int cur, int reverse, int dir) {

        if (reverse > 2 || cur < 0 || cur >= N) return Integer.MIN_VALUE;

        if (cur == N - 1) return 0;

        if (num[cur] == 0) return Integer.MIN_VALUE;

        if (dp[cur][reverse] != -1) return dp[cur][reverse];

        int time = Integer.MIN_VALUE;
        time = Math.max(time, move(cur + num[cur] * dir, reverse, dir) + 1);
        time = Math.max(time, move(cur - num[cur] * dir, reverse + 1, -dir) + 1);

        dp[cur][reverse] = time;
        return dp[cur][reverse];
    }
}
