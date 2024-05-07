import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_6603 {

    static int k;
    static int[] nums, selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            nums = new int[k];
            selected = new int[6];

            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void comb(int cnt, int idx) {

        if (cnt == 6) {
            for (int s : selected) sb.append(s).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = idx; i < k; i++) {
            selected[cnt] = nums[i];
            comb(cnt + 1, i + 1);
        }
    }
}
