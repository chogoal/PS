import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_16457 {

    static int n, m, k;
    static int[][] quest;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        quest = new int[m][k];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                quest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        key(0, 0, new boolean[2 * n]);

        System.out.println(max);
    }

    private static void key(int cur, int cnt, boolean[] selected) {

        if (cur == 2 * n) {
            if (cnt == n) {
                max = Math.max(max, check(selected));
            }
            return;
        }

        selected[cur] = true;
        key(cur + 1, cnt + 1, selected);

        selected[cur] = false;
        key(cur + 1, cnt, selected);
    }

    private static int check(boolean[] selected) {

        int count = 0; // 꺨 수 있는 퀘스트 수

        for (int i = 0; i < m; i++) {

            boolean complete = true;
            for (int j = 0; j < k; j++) {
                if (!selected[quest[i][j] - 1]) {
                    complete = false;
                    break;
                }
            }

            if (complete) count++;
        }

        return count;
    }
}
