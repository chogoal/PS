import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_2011 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();

        if (code.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[code.length() + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= code.length(); i++) {
            int number = code.charAt(i - 1) - '0'; // 현재 수
            int prev = code.charAt(i - 2) - '0'; // 앞의 수

            if (number == 0) { // 현재 수가 0이라면 무조건 앞의 수와 연결되야 함
                if (prev == 1 || prev == 2) dp[i] = dp[i - 2] % 1000000;
                else break;
            } else {
                int check = prev * 10 + number;
                if (check >= 10 && check <= 26) {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                } else {
                    dp[i] = dp[i - 1] % 1000000;
                }
            }
        }

        System.out.println(dp[code.length()]);
    }
}
