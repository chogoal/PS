import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_14501 {

    static int N;
    static int[] T, P;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        work(0, 0);

        System.out.println(max);
    }

    private static void work(int day, int profit) {

        if (day > N) return;

        if (day == N) {
            max = Math.max(max, profit);
            return;
        }

        work(day + T[day], profit + P[day]);
        work(day + 1, profit);
    }
}
