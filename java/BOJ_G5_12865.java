import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_12865 {

    static int N, K;
    static int[][] wv;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        wv = new int[N][2];
        dp = new int[N][100001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                wv[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(comb(0, 0));
    }

    private static int comb(int cur, int w) {

        if (w > K) return Integer.MIN_VALUE; // 절대 답이 될 수 없는 값 리턴

        if (cur == N) return 0; // 재귀 종료

        if (dp[cur][w] != 0) return dp[cur][w]; // 이미 계산했던 값이면 그 값 리턴

        // 최초로 계산 -> dp에 저장
        // cur번째 짐을 쌀 경우와 안 쌀 경우 중 최댓값 리턴
        dp[cur][w] = Math.max(comb(cur + 1, w + wv[cur][0]) + wv[cur][1], comb(cur + 1, w));
        return dp[cur][w];
    }
}
