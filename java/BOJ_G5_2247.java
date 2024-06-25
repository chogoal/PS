import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_2247 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long sum = 0;

        for (int i = 2; i <= n / 2; i++) {
            sum += (n / i - 1) * i % 1000000;
        }

        System.out.println(sum % 1000000);
    }
}
