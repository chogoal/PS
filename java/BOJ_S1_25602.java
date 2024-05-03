import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_25602 {

    static int N, K;
    static int[] A;
    static int[][] R, M;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        R = new int[K][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        M = new int[K][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        feed(0, 0);

        System.out.println(max);
    }

    private static void feed(int cnt, int sum) {

        if (cnt == K) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (A[i] == 0) continue;
            A[i]--;

            for (int j = 0; j < N; j++) {
                if (A[j] == 0) continue;
                A[j]--;
                feed(cnt + 1, sum + R[cnt][i] + M[cnt][j]);
                A[j]++;
            }

            A[i]++;
        }
    }
}
