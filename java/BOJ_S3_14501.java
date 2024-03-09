import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] max = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {

            // 기간 내에 할 수 있는 상담인지 확인
            if (i + T[i] > N) { max[i] = max[i + 1]; continue; }

            // i 일에 상담을 할 경우와 하지 않을 경우의 금액 비교
            if (P[i] + max[i + T[i]] > max[i + 1]) {
                max[i] = P[i] + max[i + T[i]];
            } else {
                max[i] = max[i + 1];
            }
        }

        System.out.println(max[0]);
    }
}
