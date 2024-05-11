import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_20950 {

    static int N;
    static int[][] color;
    static int gr, gg, gb;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        color = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        gr = Integer.parseInt(st.nextToken());
        gg = Integer.parseInt(st.nextToken());
        gb = Integer.parseInt(st.nextToken());

        comb(0, 0, 0, 0, 0);

        System.out.println(min);
    }

    private static void comb(int cur, int cnt, int r, int g, int b) {

        if (cnt > 7) return;

        if (cur == N) {
            if (cnt > 1) {
                int diff = Math.abs(gr - r / cnt) + Math.abs(gg - g / cnt) + Math.abs(gb - b / cnt);
                min = Math.min(min, diff);
            }
            return;
        }

        comb(cur + 1, cnt + 1, r + color[cur][0], g + color[cur][1], b + color[cur][2]);
        comb(cur + 1, cnt, r, g, b);
    }
}
