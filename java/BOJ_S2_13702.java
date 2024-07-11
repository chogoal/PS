import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_13702 {

    static int N, K;
    static int[] pot;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pot = new int[N];

        for (int i = 0; i < N; i++) {
            pot[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, pot[i]);
        }

        System.out.println(binary());
    }

    private static long binary() {

        long lo = 0, hi = max + 1;
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;

            if (check(mid)) lo = mid;
            else hi = mid;
        }

        return lo;
    }

    private static boolean check(long n) {

        if (n == 0) return false;

        int sum = 0;
        for (int i : pot) {
            sum += i / n;
        }

        return sum >= K;
    }
}
