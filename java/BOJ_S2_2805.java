import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];

        int low = 0;
        int high = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, trees[i]);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                int m = trees[i] - mid;
                if (m > 0) {
                    sum += m;
                }
            }

            if (sum >= M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(high);
    }
}
