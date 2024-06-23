import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_23888 {

    static long a, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        a = Long.parseLong(st.nextToken());
        d = Long.parseLong(st.nextToken());
        int q = Integer.parseInt(br.readLine());

        long gcd = gcd(Math.max(a, d), Math.min(a, d));

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l == r) sb.append(a + (l - 1) * d);
            else if (cmd == 1) sb.append(sum(r) - sum(l - 1));
            else if (cmd == 2) sb.append(gcd);

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static long sum(long n) {
        return a * n + (n * (n - 1) * d) / 2;
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
