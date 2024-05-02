import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_20950 {

    static int N;
    static int[][] color;
    static int[] gomduri;
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
            comb(0, 0, i, 0, 0, 0);
        }

        System.out.println(min);
    }

    private static void comb(int cnt, int idx, int goal, int r, int g, int b) {

        if (cnt == goal) {
            int sum = 0;
            sum += Math.abs(gomduri[0] - r / cnt);
            sum += Math.abs(gomduri[1] - g / cnt);
            sum += Math.abs(gomduri[2] - b / cnt);

            min = Math.min(min, sum);
            return;
        }

        for (int i = idx; i < N; i++) {
            comb(cnt + 1, i + 1, goal, r + color[i][0], g + color[i][1], b + color[i][2]);
        }
    }
}
