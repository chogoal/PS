import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G5_15681 {

    static int N, R, Q;
    static List<Integer>[] graph;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        size = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            size[i] = 1;
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(R, 0);

        for (int i = 0; i < Q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(size[u]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int cur, int prev) {
        for (int next : graph[cur]) {
            if (next == prev) continue;
            dfs(next, cur);
            size[cur] += size[next];
        }
    }
}
