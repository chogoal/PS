import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_16283 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int sheep = 0;
        for (int x = 1; x < n; x++) {
            int y = n - x;
            if (x + y != n) continue;
            if (a * x + b * y != w) continue;

            if (sheep == 0) sheep = x;
            else {
                System.out.println(-1);
                return;
            }
        }

        if (sheep == 0) sb.append(-1);
        else sb.append(sheep).append(" ").append(n - sheep);
        System.out.println(sb.toString());
    }
}
