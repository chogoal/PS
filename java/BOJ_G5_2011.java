import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_2011 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();
        int[] code = new int[n];
        int[][] dp = new int[n][2]; // [0]: 앞의 숫자와 연속, [1]: 앞의 숫자와 불연속

        for (int i = 0; i < n; i++) {
            code[i] = s.charAt(i) - '0';
        }

        if (code[0] == 0) {
            System.out.println(0);
            return;
        }
        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {

            if (code[i] == 0) {
                if (!check(code[i - 1], code[i])) {
                    System.out.println(0);
                    return;
                }
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = 0;
            } else {
                if (check(code[i - 1], code[i])) {
                    dp[i][0] = dp[i - 1][1];
                } else {
                    dp[i][0] = 0;
                }
                dp[i][1] = (dp[i - 1][0] % 1000000 + dp[i - 1][1] % 1000000) % 1000000;
            }
        }

        System.out.println((dp[n - 1][0] % 1000000 + dp[n - 1][1] % 1000000) % 1000000);
    }

    private static boolean check(int a, int b) {

        // 숫자 ab가 10~26 인지 확인
        int num = a * 10 + b;
        return num >= 10 && num <= 26;
    }
}
