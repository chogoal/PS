import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S4_2960 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] num = new boolean[N + 1];

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (num[i]) continue;

            list.add(i);
            for (int j = i * i; j <= N; j += i) {
                if (num[j]) continue;
                num[j] = true;
                list.add(j);
            }

            if (list.size() >= K) break;
        }

        System.out.println(list.get(K - 1));
    }
}
