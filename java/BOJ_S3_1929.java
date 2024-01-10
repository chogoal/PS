import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_1929 {

    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        prime = new boolean[N + 1];

        isPrime(N);

        for (int i = M; i < prime.length; i++) {
            if (!prime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static void isPrime(int n) {

        if (n < 2) return;
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) continue;

            for (int j = i * i; j < prime.length; j = j + i) { // i 배수 제거
                prime[j] = true;
            }
        }
    }

}
