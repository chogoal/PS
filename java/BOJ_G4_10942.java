import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_10942 {

    static int N;
    static int[] num;
    static int[][] palindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        palindrome = new int[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        check();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(palindrome[S][E]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void check() {

        for (int i = 1; i <= N; i++) {
            palindrome[i][i] = 1; // 길이 1짜리 팰린드롬
            if (i == N) continue;
            if (num[i] == num[i + 1]) { // 길이 2짜리 팰린드롬
                palindrome[i][i + 1] = 1;
            }
        }

        // 길이 3이상 팰린드롬
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= N - 2; j++) {
                if (num[i] == num[j] && palindrome[j + 1][i - 1] == 1) {
                    palindrome[j][i] = 1;
                }
            }
        }
    }
}
