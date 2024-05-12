import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_24954 {

    static int N;
    static int[] cost;
    static int[][] sale;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N];
        sale = new int[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(br.readLine());
            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int d = Integer.parseInt(st.nextToken());

                sale[i][a] = d;
            }
        }

        order(0, new boolean[N], 0);

        System.out.println(min);
    }

    private static void order(int cur, boolean[] selected, int sum) {

        if (cur == N) {
            min = Math.min(min, sum);
            return;
        }

        // cur 번째로 사야하는 물약 고르기
        for (int i = 0; i < N; i++) {
            if (selected[i]) continue;

            selected[i] = true;
            for (int j = 0; j < N; j++) {
                if (selected[j]) continue;
                cost[j] -= sale[i][j];
            }

            order(cur + 1, selected, sum + Math.max(cost[i], 1));

            selected[i] = false;
            for (int j = 0; j < N; j++) {
                if (selected[j]) continue;
                cost[j] += sale[i][j];
            }
        }
    }
}
