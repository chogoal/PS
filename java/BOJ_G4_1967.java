import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G4_1967 {

    static int N;
    static List<Node>[] graph;
    static int[] depth;
    static int max, maxIdx;

    static class Node {
        int idx;
        int w;

        public Node (int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        graph = new List[N + 1];
        depth = new int[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        // 루트 노드에서 가장 먼 노드 찾기
        dfs(1, 0);

        // 찾은 노드에서 가장 먼 노드 찾기
        max = 0;
        Arrays.fill(depth, 0);
        dfs(maxIdx, 0);

        System.out.println(max);
    }

    private static void dfs(int cur, int prev) {
        for (Node next : graph[cur]) {
            if (next.idx == prev) continue;

            depth[next.idx] = depth[cur] + next.w;
            if (depth[next.idx] > max) {
                max = depth[next.idx];
                maxIdx = next.idx;
            }

            dfs(next.idx, cur);
        }
    }
}
