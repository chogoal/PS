import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_2529 {

    static int N;
    static String[] sign;
    static String min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sign = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sign[i] = st.nextToken();
        }

        for (int i = 0; i <= 9; i++) {
            boolean[] selected = new boolean[10];
            selected[i] = true;

            comb(0, i + "", selected);
        }

        System.out.println(max);
        System.out.println(min);
    }

    private static void comb(int n, String num, boolean[] selected) {

        if (n == N) {
            findMin(num);
            findMax(num);
            return;
        }

        int cur = num.charAt(n) - '0';

        for (int i = 0; i < 10; i++) {
            if (selected[i]) continue;

            if (sign[n].equals("<") && cur < i) {
                selected[i] = true;
                comb(n + 1, num + i, selected);
                selected[i] = false;
            } else if (sign[n].equals(">") && cur > i) {
                selected[i] = true;
                comb(n + 1, num + i, selected);
                selected[i] = false;
            }
        }
    }

    private static void findMin(String num) {

        if (min == null) min = num;
        else {
            for (int i = 0; i <= N; i++) {
                if (min.charAt(i) == num.charAt(i)) continue;
                if (min.charAt(i) > num.charAt(i)) min = num;
                return;
            }
        }
    }

    private static void findMax(String num) {

        if (max == null) max = num;
        else {
            for (int i = 0; i <= N; i++) {
                if (max.charAt(i) == num.charAt(i)) continue;
                if (max.charAt(i) < num.charAt(i)) max = num;
                return;
            }
        }
    }
}
