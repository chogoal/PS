import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G3_2533 {

    static int N;
    static List<Integer>[] graph;
    static boolean[] isEarly;
    static int[] child;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        isEarly = new boolean[N + 1];
        child = new int[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        find(1, 0);

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (isEarly[i]) cnt++;
        }

        System.out.println(cnt);
    }


    private static void find(int cur, int prev) {

        for (int next : graph[cur]) {
            if (next == prev) continue;

            find(next, cur);

            child[cur] += child[next] + 1;
            // 자식 노드가 리프 노드이거나 얼리어답터가 아니라면, 현재 노드는 얼리어답터
            if (child[next] == 0 || !isEarly[next]) {
                isEarly[cur] = true;
            }
        }
    }
}
