import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_2792 {

    static int N, M;
    static int[] jewel;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        jewel = new int[M];

        for (int i = 0; i < M; i++) {
            jewel[i] = Integer.parseInt(br.readLine());
            if (jewel[i] > max) max = jewel[i];
        }

        System.out.println(binary());
    }

    private static int binary() {

        int lo = 0, hi = max;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (check(mid)) hi = mid;
            else lo = mid;
        }

        return hi;
    }

    private static boolean check(int n) {

        int sum = 0;
        for (int i : jewel) {
            if (i % n == 0) sum += i / n;
            else sum += i / n + 1;
        }

        return sum <= N;
    }
}
