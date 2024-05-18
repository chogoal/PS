import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G4_20544 {

    static int N;
    static int[][][][] dp;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[1001][3][3][2];

        System.out.println(game(1, 0, 0, 0));
    }

    private static int game(int cur, int prev, int pprev, int two) {

        if (cur == N) {
            if (two == 1) return 1;
            return 0;
        }

        if (dp[cur][prev][pprev][two] != 0) return dp[cur][prev][pprev][two];

        long count = 0;

        // 직전이 바닥
        if (prev == 0) {
            count += game(cur + 1, 0, prev, two) % MOD;
            count += game(cur + 1, 1, prev, two) % MOD;
            count += game(cur + 1, 2, prev, 1) % MOD;
        }
        // 직전이 높이 1 선인장
        else if (prev == 1) {
            if (pprev == 0) {
                count += game(cur + 1, 0, prev, two) % MOD;
                count += game(cur + 1, 1, prev, two) % MOD;
                count += game(cur + 1, 2, prev, 1) % MOD;
            } else {
                count += game(cur + 1, 0, prev, two) % MOD;
            }
        }
        // 직전이 높이 2 선인장
        else if (prev == 2) {
            if (pprev == 0) {
                count += game(cur + 1, 0, prev, two) % MOD;
                count += game(cur + 1, 1, prev, two) % MOD;
            } else if (pprev == 1) {
                count += game(cur + 1, 0, prev, two) % MOD;
            }
        }

        dp[cur][prev][pprev][two] = (int)(count % MOD);
        return dp[cur][prev][pprev][two];
    }
}
