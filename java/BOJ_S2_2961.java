import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_2961 {

    static int N;
    static int[][] flavor;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        flavor = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            flavor[i][0] = Integer.parseInt(st.nextToken());
            flavor[i][1] = Integer.parseInt(st.nextToken());
        }

        cook(0, 0, 1, 0);

        System.out.println(min);
    }

    private static void cook(int cur, int cnt, int s, int b) {

        if (cur == N) {
            if (cnt > 0) min = Math.min(min, Math.abs(s - b));
            return;
        }

        cook(cur + 1, cnt + 1, s * flavor[cur][0], b + flavor[cur][1]);
        cook(cur + 1, cnt, s, b);
    }
}
