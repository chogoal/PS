import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G1_17240 {

    static int N;
    static int[][] stats;
    static boolean[] visited, selected;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stats = new int[N][5];
        visited = new boolean[5];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0, 0);

        System.out.println(max);
    }

    private static void perm(int cnt, int sum) {

        if (cnt == 5) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 5; i++) { // a, b, c, d, e 줄 세우기
            if (visited[i]) continue;
            visited[i] = true;

            int maxIdx = 0, max = 0; // 해당 스탯의 최대값 찾기
            for (int j = 0; j < N; j++) {
                if (selected[j]) continue;
                if (stats[j][i] > max) { maxIdx = j; max = stats[j][i]; }
            }
            selected[maxIdx] = true;

            perm(cnt + 1, sum + max);

            visited[i] = false;
            selected[maxIdx] = false;
        }
    }
}
