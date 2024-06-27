import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_16562 {

    static int N, M, k;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] cost;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        cost = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer>[] set = new HashSet[N + 1];
        for (int i = 1; i <= N; i++) set[i] = new HashSet<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (v != w) {
                set[v].add(w);
                set[w].add(v);
            }
        }

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>(set[i]);

        int sum = 0;
        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                min = 10001;
                dfs(i);

                sum += min;
                if (sum > k) {
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(flag ? sum : "Oh no");
    }

    private static void dfs(int idx) {

        visited[idx] = true;
        min = Math.min(min, cost[idx]);

        for (int next : graph[idx]) {
            if (visited[next]) continue;
            dfs(next);
        }
    }
}
