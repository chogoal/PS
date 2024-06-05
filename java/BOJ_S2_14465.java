import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_14465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[N + 1];
        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(br.readLine());
            check[num] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= K; i++) {
            if (check[i]) cnt++;
        }

        int min = cnt;
        for (int i = 1; i + K <= N; i++) {
            if (check[i]) cnt--;
            if (check[i + K]) cnt++;
            min = Math.min(min, cnt);
        }

        System.out.println(min);
    }
}
