import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_19949 {

    static int[] answer = new int[10];
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0, 0, 0);

        System.out.println(count);
    }

    private static void solve(int cur, int a, int b, int score) {

        if (cur == 10) {
            if (score >= 5) count++;
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (a == i && b == i) continue;
            solve(cur + 1, b, i, score + (i == answer[cur] ? 1 : 0));
        }
    }
}
