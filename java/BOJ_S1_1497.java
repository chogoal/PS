import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_1497 {

    static int N, M;
    static boolean[][] play;
    static int min, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        play = new boolean[N][M];
        min = N;

        for (int i = 0; i < N; i++) {
            String yn = br.readLine().split(" ")[1];
            for (int j = 0; j < M; j++) {
                play[i][j] = yn.charAt(j) == 'Y';
            }
        }

        comb(0, 0, new int[M]);

        System.out.println(max == 0 ? -1 : min);
    }

    private static void comb(int cur, int guitar, int[] song) {

        if (cur == N) {
            int sum = 0; // 연주가능한 곡 수
            for (int s : song) { if (s > 0) sum++; }

            if (sum > max) { max = sum; min = guitar; }
            else if (sum == max) min = Math.min(min, guitar);

            return;
        }

        for (int i = 0; i < M; i++) { if (play[cur][i]) song[i]++; }
        comb(cur + 1, guitar + 1, song);

        for (int i = 0; i < M; i++) { if (play[cur][i]) song[i]--; }
        comb(cur + 1, guitar, song);
    }
}
