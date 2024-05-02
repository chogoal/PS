import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_15650 {

    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        perm(0, 0);

        System.out.println(sb.toString());
    }

    private static void perm(int cnt, int idx) {

        if (cnt == M) {
            for (int s : selected) sb.append(s).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            selected[cnt] = i + 1;
            perm(cnt + 1, i + 1);
        }
    }
}
