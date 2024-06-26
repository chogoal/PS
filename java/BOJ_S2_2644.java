import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S2_2644 {

    static int n, a, b;
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean find;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(a, 0);

        System.out.println(ans == 0 ? -1 : ans);
    }

    private static void dfs(int idx, int dist) {

        visited[idx] = true;

        for (int next : graph[idx]) {
            if (find) return;
            if (visited[next]) continue;
            if (next == b) {
                ans = dist + 1;
                find = true;
                return;
            }
            dfs(next, dist + 1);
        }
    }
}
