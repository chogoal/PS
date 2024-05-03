import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_1759 {

    static int L, C;
    static char[] alphabets, selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabets = new char[C];
        selected = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabets[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabets);

        code(0, 0);

        System.out.println(sb.toString());
    }

    private static void code(int cnt, int idx) {

        if (cnt == L) {
            if (check()) {
                for (char s : selected) sb.append(s);
                sb.append("\n");
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            selected[cnt] = alphabets[i];
            code(cnt + 1, i + 1);
        }
    }

    private static boolean check() {

        int v = 0, c = 0;
        for (char s : selected) {
            if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') v++;
            else c++;
        }

        return v >= 1 && c >= 2;
    }
}
