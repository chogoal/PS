import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_10819 {

    static int N;
    static int[] A, selected;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        selected = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);

        System.out.println(max);
    }

    private static void perm(int cnt) {

        if (cnt == N) {
            max = Math.max(max, cal());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            selected[cnt] = A[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    private static int cal() {

        int sum = 0;
        for (int i = 1; i < N; i++) {
            sum += Math.abs(selected[i - 1] - selected[i]);
        }

        return sum;
    }
}
