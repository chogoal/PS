import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_2240 {

    static int T, W;
    static int[] tree;
    static int[][] plum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        tree = new int[T];
        plum = new int[T][W + 1];

        for (int i = 0; i < T; i++) {
            tree[i] = Integer.parseInt(br.readLine()) - 1;
        }

        eat();

        int max = plum[T - 1][0];
        for (int i = 1; i <= W; i++) {
            max = Math.max(max, plum[T - 1][i]);
        }

        System.out.println(max);
    }

    private static void eat() {

        // 1초에 w번 움직여 먹은 자두, 현재 (w % 2)번 나무 아래
        for (int w = 0; w <= W; w++) {
            plum[0][w] = tree[0] == w % 2 ? 1 : 0;
        }

        // 2 ~ T초에 w번 움직여 먹은 자두
        for (int t = 1; t < T; t++) {

            // 0번 움직인 경우, 현재 1번 나무 아래
            int now = tree[t] == 0 ? 1 : 0; // 현재 서 있는 나무에서 떨어진 자두
            plum[t][0] = plum[t - 1][0] + now;

            // 1 ~ w번 움직인 경우, 현재 (w % 2)번 나무 아래
            for (int w = 1; w <= W; w++) {
                now = tree[t] == w % 2 ? 1 : 0;
                // (t - 1)초에 (w - 1)번 움직여 먹은 자두, (t - 1)초에 w번 움직여 먹은 자두
                plum[t][w] = Math.max(plum[t - 1][w - 1], plum[t - 1][w]) + now;
            }
        }
    }
}
