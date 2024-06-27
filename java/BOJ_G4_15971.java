import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G4_15971 {

    static int N, A, B;
    static List<Node>[] graph;
    static boolean[] visited;
    static int dist;

    static class Node {
        int idx;
        int len;

        public Node(int idx, int len) {
            this.idx = idx;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        dfs(A, B, 0, 0);

        System.out.println(dist);
    }

    private static void dfs(int start, int end, int sum, int max) {

        if (start == end) {
            dist = sum - max;
            return;
        }

        visited[start] = true;

        for (Node next : graph[start]) {
            if (visited[next.idx]) continue;
            dfs(next.idx, end, sum + next.len, Math.max(max, next.len));
        }
    }
}
