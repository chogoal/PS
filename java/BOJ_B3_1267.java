import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B3_1267 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cost = 0;
        int y = 0, m = 0;
        for (int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());
            y += (time / 30) * 10 + 10;
            m += (time / 60) * 15 + 15;
        }

        if (y < m) {
            sb.append("Y ").append(y);
        } else if (m < y) {
            sb.append("M ").append(m);
        } else {
            sb.append("Y M ").append(y);
        }

        System.out.println(sb.toString());
    }
}
