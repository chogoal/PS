import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_2216 {

    static int A, B, C;
    static String X, Y;
    static int[][] dp;
    static final int MIN = -99999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        X = br.readLine();
        Y = br.readLine();

        dp = new int[X.length()][Y.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], MIN);
        }

        System.out.println(compare(0, 0));
    }

    private static int compare(int x, int y) {

        // X, Y의 길이가 같으면, 종료
        if (x == X.length() && y == Y.length()) return 0;
        // X, Y의 길이가 다르면, 남은 길이만큼 B점 추가
        else if (x < X.length() && y == Y.length()) { // X가 더 남아있는 경우
            return B * (X.length() - x);
        } else if (x == X.length() && y < Y.length()) { // Y가 더 남아있는 경우
            return B * (Y.length() - y);
        }

        if (dp[x][y] != MIN) return dp[x][y];

        int score = MIN;

        // X에 공백 추가
        score = Math.max(score, compare(x, y + 1) + B);

        // Y에 공백 추가
        score = Math.max(score, compare(x + 1, y) + B);

        // 공백 추가하지 않음
        if (X.charAt(x) == Y.charAt(y)) {
            score = Math.max(score, compare(x + 1, y + 1) + A);
        } else {
            score = Math.max(score, compare(x + 1, y + 1) + C);
        }

        dp[x][y] = score;
        return dp[x][y];
    }
}
