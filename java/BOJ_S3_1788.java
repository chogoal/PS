import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_1788 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        if (n == 0) sb.append("0\n0");
        else if (n == 1) sb.append("1\n1");
        else if (n > 1) { // 양수
            long[] fibonacci = new long[n + 1];
            fibonacci[0] = 0; fibonacci[1] = 1;

            for (int i = 2; i <= n; i++) {
                fibonacci[i] = (fibonacci[i - 1] % 1000000000 + fibonacci[i - 2] % 1000000000) % 1000000000;
            }

            sb.append("1\n").append(fibonacci[n]);
        } else { // 음수
            n *= -1;
            long[] fibonacci = new long[n + 1];
            fibonacci[0] = 0; fibonacci[1] = 1;

            for (int i = 2; i <= n; i++) {
                fibonacci[i] = (fibonacci[i - 2] % 1000000000 - fibonacci[i - 1] % 1000000000) % 1000000000;
            }

            sb.append(n % 2 == 0 ? -1 : 1).append("\n");
            sb.append(Math.abs(fibonacci[n]));
        }

        System.out.println(sb.toString());
    }
}
