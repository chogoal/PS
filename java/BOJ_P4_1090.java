import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_P4_1090 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] X = new int[N];
        int[] Y = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        int[] min = new int[N];
        Arrays.fill(min, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 각각의 체커까지의 거리
                int[] dist = new int[N];
                for (int k = 0; k < N; k++) {
                    dist[k] = Math.abs(X[i] - X[k]) + Math.abs(Y[j] - Y[k]);
                }

                // 거리 정렬
                Arrays.sort(dist);

                // 가까운 k개의 체커 이동 거리 합
                int[] sum = new int[N];
                sum[0] = dist[0];
                for (int k = 1; k < N; k++) {
                    sum[k] = sum[k - 1] + dist[k];
                }

                // 최소값 갱신
                for (int k = 0; k < N; k++) {
                    min[k] = Math.min(min[k], sum[k]);
                }
            }
        }

        for (int m : min) {
            sb.append(m).append(" ");
        }
        System.out.println(sb.toString());
    }
}
