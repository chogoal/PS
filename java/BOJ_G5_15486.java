import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_15486 {

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

        long[] max = new long[N + 1];
        for (int i = N - 1; i >= 0; i--) {

            if (i + T[i] > N) { max[i] = max[i + 1]; continue; }

            long today = P[i] + max[i + T[i]];
            max[i] = Math.max(today, max[i + 1]);
        }

        System.out.println(max[0]);
    }
}
