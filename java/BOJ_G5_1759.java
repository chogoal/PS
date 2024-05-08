import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_1759 {

    static int L, C;
    static char[] alphabets;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabets = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabets[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabets);

        code(0, "");

        System.out.println(sb.toString());
    }

    private static void code(int cur, String selected) {

        if (cur == C) {
            if (selected.length() == L && check(selected)) {
                sb.append(selected).append("\n");
            }
            return;
        }

        code(cur + 1, selected + alphabets[cur]);
        code(cur + 1, selected);
    }

    private static boolean check(String selected) {

        int v = 0, c = 0;
        for (int i = 0; i < selected.length(); i++) {
            char s = selected.charAt(i);
            if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') v++;
            else c++;
        }

        return v >= 1 && c >= 2;
    }
}
