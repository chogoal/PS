import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];

        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) System.out.println(wine[0]);
        else if (n == 2) System.out.println(wine[0] + wine[1]);
        else {
            int[] dp = new int[n];
            dp[0] = wine[0];
            dp[1] = wine[0] + wine[1];

            dp[2] = Math.max(wine[0], wine[1]) + wine[2]; // 3번째 와인을 선택하는 경우
            dp[2] = Math.max(dp[1], dp[2]); // dp[1] = 3번째 와인을 선택하지 않는 경우

            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + wine[i - 1]) + wine[i];
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }

            System.out.println(dp[n - 1]);
        }
    }
}
