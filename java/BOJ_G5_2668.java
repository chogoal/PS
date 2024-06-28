import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G5_2668 {

    static int N;
    static int[] graph;
    static boolean[] visited, done;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1];
        visited = new boolean[N + 1];
        done = new boolean[N + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) dfs(i);
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (int l : list) sb.append(l).append("\n");
        System.out.println(sb.toString());
    }

    private static void dfs(int idx) {

        visited[idx] = true;

        int next = graph[idx];
        if (!visited[next]) { // 방문하지 않은 노드
            dfs(next);
        } else if (!done[next]) { // 방문했던 노드인데 탐색이 끝나지 않은 노드 (사이클)
            cycle(next, idx);
        }

        done[idx] = true;
    }

    private static void cycle(int start, int end) {

        list.add(start);

        if (start == end) return;

        cycle(graph[start], end);
    }
}
