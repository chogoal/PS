import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_2503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[504];
        int idx = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || j == k || k == i) continue;
                    numbers[idx++] = i * 100 + j * 10 + k;
                }
            }
        }

        int N = Integer.parseInt(br.readLine());
        String[] guess = new String[N];
        int[][] result = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            guess[i] = st.nextToken();
            result[i][0] = Integer.parseInt(st.nextToken()); // strike
            result[i][1] = Integer.parseInt(st.nextToken()); // ball
        }

        int cnt = 504;
        for (int i = 0; i < 504; i++) {

            boolean ok = true;
            String num = numbers[i] + "";

            for (int j = 0; j < N; j++) {

                int strike = 0;
                int ball = 0;

                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (num.charAt(n) == guess[j].charAt(m)) {
                            if (m == n) strike++;
                            else ball++;
                        }
                    }
                }

                if (strike != result[j][0] || ball != result[j][1]) {
                    ok = false;
                    break;
                }
            }

            if (!ok) cnt--;
        }

        System.out.println(cnt);
    }
}
