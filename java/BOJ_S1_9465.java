import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (n == 1) {
                sb.append(Math.max(sticker[0][0], sticker[1][0])).append("\n");
                continue;
            }

            // 최대 구하기
            int[][] max = new int[2][n];
            max[0][0] = sticker[0][0];
            max[1][0] = sticker[1][0];
            max[0][1] = max[1][0] + sticker[0][1];
            max[1][1] = max[0][0] + sticker[1][1];

            for (int i = 2; i < n; i++) {
                max[0][i] = Math.max(max[1][i - 1], max[1][i - 2]) + sticker[0][i];
                max[1][i] = Math.max(max[0][i - 1], max[0][i - 2]) + sticker[1][i];
            }

            sb.append(Math.max(max[0][n - 1], max[1][n - 1])).append("\n");
        }

        System.out.println(sb.toString());
    }
}
