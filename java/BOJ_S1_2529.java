import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S1_2529 {

    static int N;
    static char[] sign;
    static boolean[] selected;
    static List<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        sign = new char[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        selected = new boolean[10];
        answer = new ArrayList<>();

        comb(-1, "");

        sb.append(answer.get(answer.size() - 1)).append("\n").append(answer.get(0));
        System.out.println(sb.toString());
    }

    private static void comb(int n, String number) {

        if (n == N) {
            answer.add(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (selected[i]) continue;

            if (n != -1) {
                if (sign[n] == '>' && number.charAt(n) - '0' < i) continue;
                if (sign[n] == '<' && number.charAt(n) - '0' > i) continue;
            }

            selected[i] = true;
            comb(n + 1, number + i);
            selected[i] = false;
        }
    }
}
