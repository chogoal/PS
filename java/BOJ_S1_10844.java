import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] num = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            num[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    num[i][j] = num[i - 1][1] % 1000000000;
                } else if (j == 9) {
                    num[i][j] = num[i - 1][8] % 1000000000;
                } else {
                    num[i][j] = (num[i - 1][j - 1] + num[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += num[N][i];
        }

        System.out.println(answer % 1000000000);
    }
}
