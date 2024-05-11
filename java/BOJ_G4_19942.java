import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_19942 {

    static int N;
    static int[] m;
    static int[][] nutrient;
    static boolean[] selected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        m = new int[4];
        nutrient = new int[N][5];
        selected = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                nutrient[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, new boolean[N], 0, 0, 0, 0, 0);

        if (min == Integer.MAX_VALUE) {
            sb.append(-1);
        } else {
            sb.append(min).append("\n");
            for (int i = 0; i < N; i++) {
                if (selected[i]) sb.append(i + 1).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    private static void comb(int cur, boolean[] select, int p, int f, int s, int v, int c) {

        if (p >= m[0] && f >= m[1] && s >= m[2] && v >= m[3] && c < min) {
            min = c;
            for (int i = 0; i < N; i++) {
                selected[i] = select[i];
            }
            return;
        }

        if (cur == N) return;

        select[cur] = true;
        comb(cur + 1, select, p + nutrient[cur][0],
                                f + nutrient[cur][1],
                                s + nutrient[cur][2],
                                v + nutrient[cur][3],
                                c + nutrient[cur][4]);

        select[cur] = false;
        comb(cur + 1, select, p, f, s, v, c);
    }
}
