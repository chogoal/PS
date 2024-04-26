import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B1_1816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            long number = Long.parseLong(br.readLine());

            sb.append(check(number) ? "YES" : "NO").append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean check(long num) {

        for (long i = 2; i <= 1000000; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
