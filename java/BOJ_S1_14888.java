import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_14888 {

    static int N;
    static int[] A, mod;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        mod = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            mod[i] = Integer.parseInt(st.nextToken());
        }

        cal(1, A[0]);

        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
    }

    private static void cal(int cnt, int value) {

        if (cnt == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (mod[i] == 0) continue;

            mod[i]--;
            if (i == 0) cal(cnt + 1, value + A[cnt]);
            else if (i == 1) cal(cnt + 1, value - A[cnt]);
            else if (i == 2) cal(cnt + 1, value * A[cnt]);
            else cal(cnt + 1, value / A[cnt]);
            mod[i]++;
        }
    }
}
