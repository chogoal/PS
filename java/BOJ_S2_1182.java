import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_1182 {

    static int N, S;
    static int[] array;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        subset(0, 0);

        System.out.println(S == 0 ? count - 1 : count);
    }

    private static void subset(int cur, int sum) {

        if (cur == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        subset(cur + 1, sum);
        subset(cur + 1, sum + array[cur]);
    }
}
