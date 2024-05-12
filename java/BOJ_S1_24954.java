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

        comb(0, new boolean[N], new int[N]);

        System.out.println(min);
    }

    private static void comb(int cur, boolean[] selected, int[] order) {

        if (cur == N) {
            min = Math.min(min, coin(order));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            order[cur] = i;
            comb(cur + 1, selected, order);
            selected[i] = false;
        }
    }

    private static int coin(int[] order) {

        int sum = 0;
        int[] coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[order[i]] += cost[order[i]];
            for (int j = 0; j < N; j++) {
                coin[j] -= sale[order[i]][j];
            }
            sum += Math.max(coin[order[i]], 1);
        }

        return sum;
    }
}
