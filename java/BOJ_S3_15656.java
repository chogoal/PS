import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_15656 {

    static int N, M;
    static int[] numbers, selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        perm(0);

        System.out.println(sb.toString());
    }

    private static void perm(int cnt) {

        if (cnt == M) {
            for (int s : selected) sb.append(s).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            selected[cnt] = numbers[i];
            perm(cnt + 1);
        }
    }
}
