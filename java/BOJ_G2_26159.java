import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G2_26159 {

    static int N;
    static List<Integer>[] graph;
    static int[] arr, subtree;
    static long[] used;
    static final int DIVIDE = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        arr = new int[N - 1];
        subtree = new int[N + 1];
        used = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            subtree[i] = 1;
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);

        Arrays.sort(used);
        Arrays.sort(arr);

        long sum = 0;
        for (int i = 2; i <= N; i++) {
            sum += used[i] * arr[N - i] % DIVIDE;
        }

        System.out.println(sum % DIVIDE);
    }

    private static void dfs(int cur, int prev) {

        for (int next : graph[cur]) {
            if (next == prev) continue;
            dfs(next, cur);
            subtree[cur] += subtree[next];
        }

        if (prev != 0) { // 루트가 아닌 노드 (1 제외 노드)
            used[cur] = (long) subtree[cur] * (N - subtree[cur]);
        }
    }
}
