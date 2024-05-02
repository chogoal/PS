import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_16938 {

    static int N, L, R, X;
    static int[] A, selected;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 2; i <= N; i++) {
            selected = new int[i];

            comb(0, 0, i);
        }

        System.out.println(count);
    }

    private static void comb(int cnt, int idx, int goal) {

        if (cnt == goal) {
            if (isValid()) count++;
            return;
        }

        for (int i = idx; i < N; i++) {
            selected[cnt] = A[i];
            comb(cnt + 1, i + 1, goal);
        }
    }

    private static boolean isValid() {

        int sum = 0;
        for (int s : selected) sum += s;
        if (sum < L || sum > R) return false;

        int max = selected[selected.length - 1];
        int min = selected[0];
        return max - min >= X;
    }
}
