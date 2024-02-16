import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_15664 {

    static int N, M;
    static int[] array;
    static int[] selected;
    static boolean[] checked;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N];
        selected = new int[M];
        checked = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        comb(0, 0);

        System.out.println(sb.toString());
    }

    private static void comb(int cnt, int start) {

        if (cnt == M) {
            for (int s : selected) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = start; i < N; i++) {
            if (!checked[i]) {
                if (before != array[i]) {
                    before = array[i];
                    checked[i] = true;
                    selected[cnt] = array[i];
                    comb(cnt + 1, i + 1);
                    checked[i] = false;
                }
            }
        }
    }
}
