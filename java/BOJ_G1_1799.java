import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G1_1799 {

    static int N;
    static List<int[]> even, odd;
    static int max, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        even = new ArrayList<>();
        odd = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    if ((i + j) % 2 == 0) odd.add(new int[] { i, j });
                    else even.add(new int[] { i, j });
                }
            }
        }

        max = 0;
        bishopOdd(0, 0, new boolean[2 * N - 1], new boolean[2 * N - 1]);
        answer += max;

        max = 0;
        bishopEven(0, 0, new boolean[2 * N - 1], new boolean[2 * N - 1]);
        answer += max;

        System.out.println(answer);
    }

    private static void bishopOdd(int cur, int cnt, boolean[] check1, boolean[] check2) {

        if (cur == odd.size()) {
            max = Math.max(max, cnt);
            return;
        }

        int x = odd.get(cur)[0];
        int y = odd.get(cur)[1];

        if (check1[x + y] || check2[N - 1 - (x - y)]) {
            bishopOdd(cur + 1, cnt, check1, check2);
        } else {
            check1[x + y] = true;
            check2[N - 1 - (x - y)] = true;
            bishopOdd(cur + 1, cnt + 1, check1, check2);

            check1[x + y] = false;
            check2[N - 1 - (x - y)] = false;
            bishopOdd(cur + 1, cnt, check1, check2);
        }
    }

    private static void bishopEven(int cur, int cnt, boolean[] check1, boolean[] check2) {

        if (cur == even.size()) {
            max = Math.max(max, cnt);
            return;
        }

        int x = even.get(cur)[0];
        int y = even.get(cur)[1];

        if (check1[x + y] || check2[N - 1 - (x - y)]) {
            bishopEven(cur + 1, cnt, check1, check2);
        } else {
            check1[x + y] = true;
            check2[N - 1 - (x - y)] = true;
            bishopEven(cur + 1, cnt + 1, check1, check2);

            check1[x + y] = false;
            check2[N - 1 - (x - y)] = false;
            bishopEven(cur + 1, cnt, check1, check2);
        }
    }
}
