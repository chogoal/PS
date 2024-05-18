import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_5569 {

    static int W, H;
    static int[][][][] dp;
    static final int MOD = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dp = new int[101][101][3][3];

        System.out.println(move(1, 1, 0, 0));
    }

    private static int move(int w, int h, int prev, int pprev) {

        if (w > W || h > H) return 0;
        if (w == W && h == H) return 1;

        if (dp[w][h][prev][pprev] != 0) return dp[w][h][prev][pprev];

        int count = 0;

        // 직전에 동쪽으로 이동
        if (prev == 1) {
            if (pprev == 2) {
                count += move(w + 1, h, 1, prev) % MOD;
            } else {
                count += move(w, h + 1, 2, prev) % MOD;
                count += move(w + 1, h, 1, prev) % MOD;
            }
        }
        // 직전에 북쪽으로 이동
        else {
            if (pprev == 1) {
                count += move(w, h + 1, 2, prev) % MOD;
            } else {
                count += move(w, h + 1, 2, prev) % MOD;
                count += move(w + 1, h, 1, prev) % MOD;
            }
        }

        dp[w][h][prev][pprev] = count % MOD;
        return dp[w][h][prev][pprev];
    }
}
