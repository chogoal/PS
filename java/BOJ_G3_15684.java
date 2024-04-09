import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_15684 {

    static int N, M, H;
    static boolean[][] ladder;
    static int min = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로선
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken()); // 점선
        ladder = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a][b] = true; // 가로선
        }

        // 현 상태에서 체크
        if (check()) min = 0;
        else {
            for (int i = 1; i <= 3; i++) {
                if (addLadder(i, 0, 1)) {
                    min = i;
                    break;
                }
            }
        }

        System.out.println(min);
    }

    private static boolean check() { // i번 세로선의 결과가 i가 나오는지 확인

        for (int i = 1; i <= N; i++) { // i번 세로선
            int line = i;
            for (int j = 1; j <= H; j++) {
                if (ladder[j][line]) line++;
                else if (ladder[j][line - 1]) line--;
            }

            if (line != i) return false;
        }

        return true;
    }

    private static boolean addLadder(int cnt, int idx, int start) {

        if (idx == cnt) {
            return check();
        }

        for (int i = start; i < N; i++) {
            for (int j = 1; j <= H; j++) {
                if (ladder[j][i]) continue;

                if (!ladder[j][i - 1] && !ladder[j][i + 1]) {
                    ladder[j][i] = true;

                    if (addLadder(cnt, idx + 1, i)) return true;
                    else ladder[j][i] = false;
                }
            }
        }

        return false;
    }
}
