import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G4_14267 {

    static int n, m;
    static List<Integer>[] graph;
    static int[] comp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new List[n + 1];
        comp = new int[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                graph[parent].add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            comp[idx] += w;
        }

        dfs(1);

        for (int i = 1; i <= n; i++) {
            sb.append(comp[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int cur) {

        for (int next : graph[cur]) {
            comp[next] += comp[cur];
            dfs(next);
        }
    }
}
