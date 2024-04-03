import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine()); // 목표 금액

            sb.append(count(N, coin, M)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int count(int N, int[] coin, int M) {

        int[] count = new int[M + 1];

        for (int i = 0; i < N; i++) {

            if (coin[i] > M) break;

            count[coin[i]]++;
            for (int j = coin[i] + 1; j <= M; j++) {
                count[j] += count[j - coin[i]];
            }
        }

        return count[M];
    }
}
