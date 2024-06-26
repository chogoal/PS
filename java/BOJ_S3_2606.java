import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S3_2606 {

    static int N;
    static List<Integer>[] list;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        System.out.println(cnt);
    }

    private static void dfs(int idx) {

        visited[idx] = true;

        for (int next : list[idx]) {
            if (visited[next]) continue;
            cnt++;
            dfs(next);
        }
    }
}
