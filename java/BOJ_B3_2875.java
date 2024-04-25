import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B3_2875 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int x = 0, y = 0, cnt = 0;
        while (true) {
            x += 2; y += 1;
            if (x > N || y > M || x + y + K > M + N) break;
            cnt++;
        }

        System.out.println(cnt);
    }
}
