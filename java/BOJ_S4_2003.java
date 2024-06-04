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
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int sum = arr[0], s = 0, e = 0;

        while (e < N) {
            if (sum == M) {
                cnt++;
                sum -= arr[s];
                s++;
            } else if (sum < M) {
                e++;
                if (e == N) break;
                sum += arr[e];
            } else {
                sum -= arr[s];
                s++;
            }
        }

        System.out.println(cnt);
    }
}
