import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_1695 {

    static int N;
    static int[] array;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        array = new int[N];
        dp = new int[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(insert(0, N - 1));
    }

    private static int insert(int fIdx, int bIdx) {

        if (fIdx < 0 || fIdx >= N || bIdx < 0 || bIdx >= N) return 0;

        if (fIdx >= bIdx) return 0;

        if (dp[fIdx][bIdx] != 0) return dp[fIdx][bIdx];

        if (array[fIdx] == array[bIdx]) {
            dp[fIdx][bIdx] = insert(fIdx + 1, bIdx - 1);
        } else {
            dp[fIdx][bIdx] = Math.min(insert(fIdx, bIdx - 1), insert(fIdx + 1, bIdx)) + 1;
        }

        return dp[fIdx][bIdx];
    }
}
