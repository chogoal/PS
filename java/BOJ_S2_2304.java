import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_2304 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] height = new int[1001];

        int from = 1001, to = 0; // x범위
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            height[L] = H;
            from = Math.min(from, L);
            to = Math.max(to, L);
        }

        int sum = 0;
        for (int i = 1; i <= 1000; i++) {

            int min = -1;
            for (int j = from; j <= to; j++) {
                if (height[j] >= i) { min = j; break; }
            }
            if (min == -1) break;

            int max = -1;
            for (int j = to; j >= from; j--) {
                if (height[j] >= i) { max = j; break; }
            }

            sum += (max + 1 - min);
        }

        System.out.println(sum);
    }
}
