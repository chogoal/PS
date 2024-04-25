import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B3_14568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int a = 2; a < N; a += 2) {
            for (int b = 1; b < N; b++) {
                for (int c = 1; c < N; c++) {
                    if (a + b + c != N) continue;
                    if (c < b + 2) continue;

                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
