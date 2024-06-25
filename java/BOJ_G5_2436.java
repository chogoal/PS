import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_2436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());
        int N = lcm / gcd;

        int a = 1, b = N;
        int sum = a + b;

        for (int i = 2; i < Math.sqrt(N); i++) {
            if (N % i == 0 && gcd(N / i, i) == 1) { // 두 약수가 서로소
                if (i + N / i < sum) {
                    a = i;
                    b = N / i;
                }
            }
        }

        sb.append(a * gcd).append(" ").append(b * gcd);
        System.out.println(sb.toString());
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
