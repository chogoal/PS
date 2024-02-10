import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_1932 {

    static int n;
    static int[][] triangle;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
                if (i == n - 1) {
                    dp[i][j] = triangle[i][j];
                }
            }
        }

        System.out.println(search(0, 0));
    }

    private static int search(int i, int j) {

        if (i == n - 1) {
            return dp[i][j];
        }

        if (dp[i][j] == null) {
            dp[i][j] = Math.max(search(i + 1, j), search(i + 1, j + 1)) + triangle[i][j];
        }

        return dp[i][j];
    }
}
