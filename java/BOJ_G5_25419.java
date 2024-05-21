import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_25419 {

    static int N, K;
    static boolean[] num;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new boolean[N + 1];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            num[Integer.parseInt(st.nextToken())] = true;
        }

        Arrays.fill(dp, -1);

        int result = game(0);
        System.out.println(result == 1 ? 1 : 0);
    }

    private static int game(int cur) {

        if (num[cur]) return 1;

        if (dp[cur] != -1) return dp[cur];

        dp[cur] = 0;
        for (int i = cur + 1; i <= cur + K; i++) {
            if (i > N) break;
            if (game(i) == 0) { dp[cur] = 1; break; }
        }
        return dp[cur];
    }
}
