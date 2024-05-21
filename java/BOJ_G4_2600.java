import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_2600 {

    static int b1, b2, b3;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        b1 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());
        b3 = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());

            dp = new int[k1 + 1][k2 + 1];
            for (int j = 0; j < dp.length; j++) {
                Arrays.fill(dp[j], -1);
            }

            int winner = game(k1, k2);
            sb.append(winner == 1 ? "A" : "B").append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int game(int first, int second) {

        if (first < 0 || second < 0) return 1;

        if (first < b1 && second < b1) return 0;

        if (dp[first][second] != -1) return dp[first][second];

        if (game(first - b1, second) == 0) return dp[first][second] = 1;
        if (game(first - b2, second) == 0) return dp[first][second] = 1;
        if (game(first - b3, second) == 0) return dp[first][second] = 1;

        if (game(first, second - b1) == 0) return dp[first][second] = 1;
        if (game(first, second - b2) == 0) return dp[first][second] = 1;
        if (game(first, second - b3) == 0) return dp[first][second] = 1;

        dp[first][second] = 0;
        return dp[first][second];
    }
}
