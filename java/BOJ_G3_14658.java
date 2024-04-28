import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_14658 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] stars = new int[K][2];
        int[] xs = new int[K];
        int[] ys = new int[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stars[i][0] = x; stars[i][1] = y;
            xs[i] = x; ys[i] = y;
        }

        int max = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {

                int count = 0;
                for (int k = 0; k < K; k++) {
                    if (stars[k][0] >= xs[i] && stars[k][0] <= xs[i] + L &&
                        stars[k][1] >= ys[j] && stars[k][1] <= ys[j] + L) count++;
                }

                max = Math.max(max, count);
            }
        }

        System.out.println(K - max);
    }
}
