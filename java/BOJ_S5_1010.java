import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S5_1010 {

    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dp = new int[M][N];
            for (int i = 0; i < M; i++) {
                Arrays.fill(dp[i], -1);
            }

            sb.append(find(0, 0)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int find(int cur, int cnt) {

        if (cur == M) {
            if (cnt == N) return 1;
            return 0;
        }

        if (cnt == N) return 1;

        if (dp[cur][cnt] != -1) return dp[cur][cnt];

        dp[cur][cnt] = 0;
        dp[cur][cnt] += find(cur + 1, cnt + 1);
        dp[cur][cnt] += find(cur + 1, cnt);

        return dp[cur][cnt];
    }
}
