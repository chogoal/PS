import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_6603 {

    static int N;
    static int[] array;
    static int[] selected;
    static boolean[] checked;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            array = new int[N];
            selected = new int[6];
            checked = new boolean[N];

            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void comb(int cnt, int start) {

        if (cnt == 6) {
            for (int s : selected) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                selected[cnt] = array[i];
                comb(cnt + 1, i + 1);
                checked[i] = false;
            }
        }
    }
}
