import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cal = new int[N + 1];
        cal[0] = cal[1] = 0;

        for (int i = 2; i < N + 1; i++) {
            cal[i] = cal[i - 1] + 1;
            if (i % 3 == 0) {
                cal[i] = Math.min(cal[i], cal[i / 3] + 1);
            }
            if (i % 2 == 0) {
                cal[i] = Math.min(cal[i], cal[i / 2] + 1);
            }
        }

        System.out.println(cal[N]);
    }
}
