import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_2698 {

    static int n, k;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            dp = new int[n][2][k + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }

            sb.append(count(0, 0, 0)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int count(int cur, int prev, int cnt) {

        if (cnt > k) return 0;

        if (cur == n) {
            if (cnt == k) return 1;
            return 0;
        }

        if (dp[cur][prev][cnt] != -1) return dp[cur][prev][cnt];

        dp[cur][prev][cnt] = 0;
        dp[cur][prev][cnt] += count(cur + 1, 0, cnt);
        dp[cur][prev][cnt] += count(cur + 1, 1, cnt + prev);

        return dp[cur][prev][cnt];
    }
}
