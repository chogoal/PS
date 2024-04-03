import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] count = new int[k + 1];

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());

            if (coin > k) continue;

            count[coin]++;
            for (int j = coin + 1; j <= k; j++) {
                count[j] += count[j - coin];
            }
        }

        System.out.println(count[k]);
    }
}
