import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] pn = new long[101];
        pn[1] = pn[2] = pn[3] = 1;
        pn[4] = pn[5] = 2;
        for (int i = 6; i < 101; i++) {
            pn[i] = pn[i - 5] + pn[i - 1];
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(pn[N]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
