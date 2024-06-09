import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G2_22988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        long[] C = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            C[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(C);

        int s = 0, e = N - 1;
        int cnt = 0;

        while (s <= e) {
            if (C[e] == X) {
                cnt++;
                N--;
                e--;
                continue;
            }

            if (s == e) break;

            if (C[s] + C[e] >= X / 2.0) {
                cnt++;
                s++;
                e--;
                N -= 2;
            } else {
                s++;
            }
        }

        System.out.println(cnt + N / 3);
    }
}
