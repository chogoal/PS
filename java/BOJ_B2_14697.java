import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_14697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int ans = 0;
        ex:
        for (int a = 0; a <= N / A; a++) {
            for (int b = 0; b <= N / B; b++) {
                for (int c = 0; c <= N / C; c++) {
                    if (A * a + B * b + C * c == N) {
                        ans = 1;
                        break ex;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
