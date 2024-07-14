import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_13325 {

    static int k, n;
    static int[] w;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        n = (int) Math.pow(2, k + 1);
        w = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        dist(1);

        System.out.println(sum);
    }

    private static void dist(int idx) {

        // 현재 가중치값
        sum += w[idx];

        int next = idx * 2;
        if (next >= n) {
            return;
        }

        dist(next);
        dist(next + 1);

        // 더 큰 가중치값에 맞춰 더해주기
        sum += Math.abs(w[next] - w[next + 1]);
        w[idx] += Math.max(w[next], w[next + 1]);
    }
}
