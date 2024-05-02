import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_20950 {

    static int N;
    static int[][] color;
    static int[] gomduri, munduri, selected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        color = new int[N][3];
        gomduri = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            gomduri[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= 7; i++) {
            selected = new int[i];

            comb(0, 0, i);
        }

        System.out.println(min);
    }

    private static void comb(int cnt, int idx, int goal) {

        if (cnt == goal) {
            min = Math.min(min, rgb(cnt));
            return;
        }

        for (int i = idx; i < N; i++) {
            selected[cnt] = i;
            comb(cnt + 1, i + 1, goal);
        }
    }

    private static int rgb(int cnt) {

        munduri = new int[3];
        for (int s : selected) {
            for (int i = 0; i < 3; i++) munduri[i] += color[s][i];
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += Math.abs(gomduri[i] - munduri[i] / cnt);
        }

        return sum;
    }
}
