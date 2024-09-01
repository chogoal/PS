import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G2_9007 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            // 1, 2반 몸무게 합 경우의 수
            int[][] weights1 = new int[2][N];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    weights1[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] sum1 = new int[N * N];
            int idx = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sum1[idx++] = weights1[0][i] + weights1[1][j];
                }
            }

            // 3, 4반 몸무게 합 경우의 수
            int[][] weights2 = new int[2][N];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    weights2[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] sum2 = new int[N * N];
            idx = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sum2[idx++] = weights2[0][i] + weights2[1][j];
                }
            }

            Arrays.sort(sum1);
            Arrays.sort(sum2);

            int s = 0, e = N * N - 1;
            int ans = sum1[s] + sum2[e];
            int min = Integer.MAX_VALUE;

            while (true) {
                if (s >= N * N || e < 0) break;

                int sum = sum1[s] + sum2[e];
                int diff = Math.abs(K - sum);

                if (sum == K) {
                    ans = sum;
                    break;
                } else if (sum < K) {
                    s++;
                    if (diff < min) {
                        ans = sum;
                        min = diff;
                    } else if (diff == min && ans > sum) {
                        ans = sum;
                    }
                } else {
                    e--;
                    if (diff < min) {
                        ans = sum;
                        min = diff;
                    } else if (diff == min && ans > sum) {
                        ans = sum;
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }
}
