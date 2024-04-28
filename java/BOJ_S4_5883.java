import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_S4_5883 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];

        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(br.readLine());
            B.add(line[i]);
        }

        int ans = 0;
        for (int b : B) {
            int len = 1; // 연속 구간의 길이
            int max = 0; // 연속 구간 길이의 최대
            int before = -1;

            for (int i = 0; i < N; i++) {
                if (line[i] == b) continue;
                if (line[i] == before) len++;
                else {
                    max = Math.max(max, len);
                    before = line[i];
                    len = 1;
                }
            }

            ans = Math.max(ans, Math.max(max, len));
        }

        System.out.println(ans);
    }
}
