import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] liquid = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = N - 1;
        int ans1 = s, ans2 = e;
        long min = Long.MAX_VALUE;

        while (s < e) {
            long sum = liquid[s] + liquid[e];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ans1 = s;
                ans2 = e;
            }

            if (sum >= 0) e--;
            else s++;
        }

        sb.append(liquid[ans1]).append(" ").append(liquid[ans2]);
        System.out.println(sb.toString());
    }
}
