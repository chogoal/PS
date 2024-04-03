import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] count = new int[k + 1];

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());

            if (coin > k) continue; // 동전이 목표 금액보다 큰 가치인 경우

            count[coin] = 1;
            for (int j = coin + 1; j <= k; j++) {
                if (count[j - coin] == 0) continue;
                else if (count[j] == 0) count[j] = count[j - coin] + 1;
                else count[j] = Math.min(count[j], count[j - coin] + 1);
            }
        }

        System.out.println(count[k] == 0 ? -1 : count[k]);
    }
}
