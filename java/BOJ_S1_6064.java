import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
tc:     for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 최소공배수
            int lcm = M * N / GCD(M, N);

            int ans = x;
            while (ans <= lcm) {
                if ((ans - y) % N == 0) {
                    sb.append(ans).append("\n");
                    continue tc;
                }
                ans += M;
            }
            sb.append(-1).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }
}
