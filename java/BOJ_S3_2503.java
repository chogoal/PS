import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_2503 {

    static int N;
    static int[][] guess;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        guess = new int[N][5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String number = st.nextToken(); // number
            guess[i][0] = number.charAt(0) - '0';
            guess[i][1] = number.charAt(1) - '0';
            guess[i][2] = number.charAt(2) - '0';
            guess[i][3] = Integer.parseInt(st.nextToken()); // strike
            guess[i][4] = Integer.parseInt(st.nextToken()); // ball
        }

        int cnt = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || j == k || k == i) continue;

                    if (check(i, j, k)) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static boolean check(int i, int j, int k) {

        for (int n = 0; n < N; n++) {

            int strike = 0;
            int ball = 0;

            if (guess[n][0] == i) strike++;
            if (guess[n][1] == j) strike++;
            if (guess[n][2] == k) strike++;

            if (guess[n][0] == j || guess[n][0] == k) ball++;
            if (guess[n][1] == i || guess[n][1] == k) ball++;
            if (guess[n][2] == i || guess[n][2] == j) ball++;

            if (guess[n][3] != strike || guess[n][4] != ball) return false;
        }

        return true;
    }
}
