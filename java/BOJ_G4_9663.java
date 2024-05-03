import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G4_9663 {

    static int N;
    static boolean[] r, c, u, d;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        r = new boolean[N];
        c = new boolean[N];
        u = new boolean[2 * N - 1];
        d = new boolean[2 * N - 1];

        queen(0);

        System.out.println(count);
    }

    private static void queen(int cnt) {

        if (cnt == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (c[i] || u[cnt + i] || d[(N - 1) - (cnt - i)]) continue;

            c[i] = true;
            u[cnt + i] = true;
            d[(N - 1) - (cnt - i)] = true;

            queen(cnt + 1);

            c[i] = false;
            u[cnt + i] = false;
            d[(N - 1) - (cnt - i)] = false;
        }
    }
}
