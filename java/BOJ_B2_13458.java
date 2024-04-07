import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_13458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] tester = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tester[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long count = 0;

        // 총감독
        for (int i = 0; i < N; i++) {
            count++;
            tester[i] -= B;
        }

        // 부감독
        for (int i = 0; i < N; i++) {
            if (tester[i] <= 0) continue;
            count += tester[i] / C;
            count += tester[i] % C > 0 ? 1 : 0;
        }

        System.out.println(count);
    }
}
