import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_14232 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long k = Long.parseLong(br.readLine());

        int cnt = 0;
        for (int i = 2; i <= Math.sqrt(k); i++) {
            while (k % i == 0) {
                cnt++;
                k /= i;
                sb.append(i).append(" ");
            }
        }

        if (k != 1) {
            cnt++;
            sb.append(k);
        }

        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}
