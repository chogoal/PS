import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_14889 {

    static int N;
    static int[][] stats;
    static boolean[] team;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stats = new int[N][N];
        team = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);

        System.out.println(min);
    }

    private static void comb(int cnt, int start) {

        if (cnt == N / 2) {
            min = Math.min(min, cal());
            return;
        }

        for (int i = start; i < N; i++) {
            if (!team[i]) {
                team[i] = true;
                comb(cnt + 1, i + 1);
                team[i] = false;
            }
        }
    }

    private static int cal() {

        int trueScore = 0;
        int falseScore = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (team[i] && team[j]) {
                    trueScore += stats[i][j];
                } else if (!team[i] && !team[j]) {
                    falseScore += stats[i][j];
                }
            }
        }

        return Math.abs(trueScore - falseScore);
    }
}
