import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1915 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] array = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                array[i][j] = line.charAt(j - 1) - '0';
            }
        }

        int max = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (array[i][j] == 0) dp[i][j] = 0;
                else { // array[i][j] == 1
                    int a = dp[i][j - 1];
                    int b = dp[i - 1][j - 1];
                    int c = dp[i - 1][j];

                    if (a + b + c < 3) { // 0이 존재
                        dp[i][j] = 1;
                    } else { // a, b, c가 모두 1 이상
                        dp[i][j] = Math.min(Math.min(a, b), c) + 1;
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }

        System.out.println(max * max);
    }
}
