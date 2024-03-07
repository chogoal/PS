import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] order = new int[N];
        int[] sum = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            order[i] = 1;
            sum[i] = array[i];

            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && order[i] < order[j] + 1) {
                    order[i] = order[j] + 1;
                    if (sum[i] < sum[j] + array[i]) {
                        sum[i] = sum[j] + array[i];
                    }
                }
            }
        }

        int max = 0;
        for (int s : sum) {
            max = Math.max(max, s);
        }

        System.out.println(max);
    }
}
