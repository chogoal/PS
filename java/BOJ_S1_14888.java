import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_14888 {

    static int N;
    static int[] number;
    static int[] opCnt = new int[4];

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            opCnt[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, number[0]);

        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
    }

    private static void dfs(int cnt, int value) {

        if (cnt == N - 1) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opCnt[i] > 0) {
                opCnt[i]--;

                switch (i) {
                    case 0: dfs(cnt + 1, value + number[cnt + 1]); break;
                    case 1: dfs(cnt + 1, value - number[cnt + 1]); break;
                    case 2: dfs(cnt + 1, value * number[cnt + 1]); break;
                    case 3: dfs(cnt + 1, value / number[cnt + 1]); break;
                }

                opCnt[i]++;
            }
        }
    }
}
