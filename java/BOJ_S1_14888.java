import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_14888 {

    static int N;
    static int[] number;

    static int[] op; // 0: 덧셈, 1: 뺄셈, 2: 곱셈, 3: 나눗셈
    static boolean[] selected;

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        op = new int[N - 1];
        selected = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int count = Integer.parseInt(st.nextToken());
            while (count-- > 0) op[index++] = i;
        }

        perm(0, number[0]);

        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
    }

    private static void perm(int cnt, int value) {

        if (cnt == N - 1) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        for (int i = 1; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;

                switch (op[i - 1]) {
                    case 0: perm(cnt + 1, value + number[cnt + 1]); break;
                    case 1: perm(cnt + 1, value - number[cnt + 1]); break;
                    case 2: perm(cnt + 1, value * number[cnt + 1]); break;
                    case 3: perm(cnt + 1, value / number[cnt + 1]); break;
                }

                selected[i] = false;
            }
        }
    }
}
