import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(divide(B) - divide(A - 1));
    }

    private static long divide(long n) {

        long sum = 0;
        long two = 1; // 2의 거듭제곱 (0부터)

        while (n > 0) {
            if (n % 2 == 0) sum += n / 2 * two;
            else sum += (n / 2 + 1) * two;
            n /= 2;
            two *= 2;
        }

        return sum;
    }
}
