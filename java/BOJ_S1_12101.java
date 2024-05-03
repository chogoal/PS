import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S1_12101 {

    static int n, k;
    static List<StringBuilder> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            sum(i, new StringBuilder().append(i));
        }

        System.out.println(list.size() < k ? -1 : list.get(k - 1));
    }

    private static void sum(int value, StringBuilder sb) {

        if (value > n) return;

        if (value == n) {
            list.add(sb);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            sum(value + i, new StringBuilder(sb).append("+").append(i));
        }
    }
}
