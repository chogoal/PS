import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_2004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        if (m == 0) System.out.println(0);
        else {
            long two = two(n) - two(m) - two(n - m);
            long five = five(n) - five(m) - five(n - m);
            System.out.println(Math.min(two, five));
        }
    }

    private static long two(long n) { // n!에 포함된 2의 개수

        long cnt = 0;
        for (long i = 2; i <= n; i *= 2) {
            cnt += n / i;
        }

        return cnt;
    }

    private static long five(long n) {

        long cnt = 0;
        for (long i = 5; i <= n; i *= 5) {
            cnt += n / i;
        }

        return cnt;
    }
}
