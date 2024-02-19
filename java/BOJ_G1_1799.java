import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G1_1799 {

    static int N;
    static int max;
    static int[][] chess;
    static boolean[] diaUpCheck;
    static boolean[] diaDownCheck;
    static ArrayList<int[]>[] list = new ArrayList[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        chess = new int[N][N];
        diaUpCheck = new boolean[2 * N - 1];
        diaDownCheck = new boolean[2 * N - 1];

        for (int i = 0; i < 2; i++) {
            list[i] = new ArrayList<int[]>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
                if (chess[i][j] == 1) {
                    if ((i + j) % 2 == 0) list[0].add(new int[] { i, j });
                    else list[1].add(new int[] { i, j });
                }
            }
        }

        max = 0;
        bishop(0, 0, 0);
        int evenMax = max;

        max = 0;
        bishop(0, 1, 0);
        int oddMax = max;

        System.out.println(evenMax + oddMax);
    }

    private static void bishop(int cnt, int color, int start) {

        for (int i = start; i < list[color].size(); i++) {
            int x = list[color].get(i)[0];
            int y = list[color].get(i)[1];

            if (diaUpCheck[x + y] || diaDownCheck[x - y + N - 1]) continue;

            diaUpCheck[x + y] = true;
            diaDownCheck[x - y + N - 1] = true;

            bishop(cnt + 1, color, i + 1);

            diaUpCheck[x + y] = false;
            diaDownCheck[x - y + N - 1] = false;
        }

        max = Math.max(max, cnt);
    }
}
