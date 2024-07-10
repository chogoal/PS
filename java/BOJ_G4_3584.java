import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G4_3584 {

    static int N;
    static List<Integer>[] graph;
    static int A, B;
    static boolean[] parentA, parentB;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            N = Integer.parseInt(br.readLine());
            graph = new List[N + 1];
            parentA = new boolean[N + 1];
            parentB = new boolean[N + 1];
            depth = new int[N + 1];

            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

            boolean[] parent = new boolean[N + 1];
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                parent[v] = true;

                graph[u].add(v);
                graph[v].add(u);
            }

            int root = 0;
            for (int i = 1; i <= N; i++) {
                if (!parent[i]) {
                    root = i;
                    break;
                }
            }

            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // A의 조상
            dfsA(root, 0);

            // B의 조상
            dfsB(root, 0);

            int min = -1;
            int minIdx = 0;
            for (int i = 1; i <= N; i++) {
                if (parentA[i] && parentB[i]) {
                    if (depth[i] > min) {
                        min = depth[i];
                        minIdx = i;
                    }
                }
            }

            sb.append(minIdx).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfsA(int cur, int prev) {

        if (cur == A) parentA[cur] = true;

        for (int next : graph[cur]) {
            if (next == prev) continue;
            depth[next] = depth[cur] + 1;
            dfsA(next, cur);
            if (parentA[next]) parentA[cur] = true;
        }
    }

    private static void dfsB(int cur, int prev) {

        if (cur == B) parentB[cur] = true;

        for (int next : graph[cur]) {
            if (next == prev) continue;
            dfsB(next, cur);
            if (parentB[next]) parentB[cur] = true;
        }
    }
}
