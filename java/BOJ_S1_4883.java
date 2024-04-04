import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_4883 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; ; tc++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            int[][] graph = new int[N][3];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(tc).append(". ").append(cost(N, graph)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int cost(int N, int[][] graph) {

        int[][] dp = new int[N][3];
        dp[0][0] = 1001;
        dp[0][1] = graph[0][1];
        dp[0][2] = graph[0][1] + graph[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + graph[i][0];
            dp[i][1] = Math.min(Math.min(dp[i - 1][0], dp[i][0]), Math.min(dp[i - 1][1], dp[i - 1][2])) + graph[i][1];
            dp[i][2] = Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2])) + graph[i][2];
        }

        return dp[N - 1][1];
    }
}
