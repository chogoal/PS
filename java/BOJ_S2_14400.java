import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_14400 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] X = new int[N];
        int[] Y = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(X);
        Arrays.sort(Y);

        int targetX = X[(N - 1) / 2];
        int targetY = Y[(N - 1) / 2];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.abs(targetX - X[i]) + Math.abs(targetY - Y[i]);
        }

        System.out.println(sum);
    }
}
