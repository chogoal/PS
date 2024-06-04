import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int sum = arr[0], s = 0, e = 0;

        while (true) {
            if (sum == M) {
                cnt++;
                sum -= arr[s++];
                sum += arr[++e];
            } else if (sum < M) {
                sum += arr[++e];
            } else {
                sum -= arr[s++];
            }

            if (e == N) break;
        }

        System.out.println(cnt);
    }
}
