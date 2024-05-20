import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_2616 {

    static int N, K;
    static int[] people;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        people = new int[N];
        dp = new int[N][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        K = Integer.parseInt(br.readLine());

        System.out.println(recur(0, 0));
    }

    private static int recur(int cur, int cnt) {

        if (cnt == 3) return 0;

        if (cur > N - K) return Integer.MIN_VALUE;

        if (dp[cur][cnt] != -1) return dp[cur][cnt];

        int count = 0;
        for (int i = cur; i < cur + K; i++) {
            count += people[i];
        }

        dp[cur][cnt] = Math.max(recur(cur + K, cnt + 1) + count, recur(cur + 1, cnt));
        return dp[cur][cnt];
    }
}
