import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_1182 {

    static int N, S;
    static int[] numbers, selected;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            selected = new int[i];

            comb(0, 0, i);
        }

        System.out.println(count);
    }

    private static void comb(int cnt, int idx, int goal) {

        if (cnt == goal) {
            int sum = 0;
            for (int s : selected) sum += s;
            if (sum == S) count++;
            return;
        }

        for (int i = idx; i < N; i++) {
            selected[cnt] = numbers[i];
            comb(cnt + 1, i + 1, goal);
        }
    }
}