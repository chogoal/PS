import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_2302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 좌석 개수
        int M = Integer.parseInt(br.readLine()); // 고정석 개수
        int[] vip = new int[M + 1]; // 고정석
        for (int i = 1; i <= M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int result = 1;
        int start = N + 1;
        for (int i = M; i >= 0; i--) {
            result *= dp[start - vip[i] - 1];
            start = vip[i];
        }

        System.out.println(result);
    }
}
