import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G4_9663 {

    static int N;
    static int count;
    static boolean[] colCheck; // 세로
    static boolean[] diaUpCheck; // y = x
    static boolean[] diaDownCheck; // y = -x

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        colCheck = new boolean[N];
        diaUpCheck = new boolean[2 * N - 1];
        diaDownCheck = new boolean[2 * N - 1];

        queen(0);

        System.out.println(count);
    }

    private static void queen(int cnt) { // cnt : 가로 체크 및 퀸의 개수

        if (cnt == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (colCheck[i] || diaUpCheck[i + cnt] || diaDownCheck[N - 1 + i - cnt]) {
                continue;
            }

            colCheck[i] = true;
            diaUpCheck[i + cnt] = true;
            diaDownCheck[N - 1 + i - cnt] = true;

            queen(cnt + 1);

            colCheck[i] = false;
            diaUpCheck[i + cnt] = false;
            diaDownCheck[N - 1 + i - cnt] = false;
        }
    }
}
