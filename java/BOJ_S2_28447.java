import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_28447 {

    static int N, K;
    static int[][] taste;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        taste = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                taste[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0, new boolean[N]);

        System.out.println(max);
    }

    private static void comb(int cur, int cnt, boolean[] selected) {

        if (cur == N) {
            if (cnt == K) {
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    if (!selected[i]) continue;
                    for (int j = i; j < N; j++) {
                        if (!selected[j]) continue;
                        sum += taste[i][j];
                    }
                }
                max = Math.max(max, sum);
            }
            return;
        }

        selected[cur] = true;
        comb(cur + 1, cnt + 1, selected);

        selected[cur] = false;
        comb(cur + 1, cnt, selected);
    }
}
