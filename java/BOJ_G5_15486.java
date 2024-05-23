import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_15486 {

    static int N;
    static int[] T, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(find());
    }

    private static int find() {

        int[] dp = new int[N + 1];

        for (int i = N - 1; i >= 0; i--) {
            if (i + T[i] > N) dp[i] = dp[i + 1];
            else dp[i] = Math.max(dp[i + T[i]] + P[i], dp[i + 1]);
        }

        return dp[0];
    }
}
