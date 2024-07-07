import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G3_1238 {

    static int N, M, X;
    static List<Node>[] graph;
    static List<Node>[] reverse;
    static int[] time;
    static int[] time_reverse;

    static class Node implements Comparable<Node> {
        int idx;
        int t;

        public Node (int idx, int t) {
            this.idx = idx;
            this.t = t;
        }

        public int compareTo(Node o) {
            return this.t - o.t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverse = new ArrayList[N + 1];
        time = new int[N + 1];
        time_reverse = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
            time[i] = Integer.MAX_VALUE;
            time_reverse[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            reverse[v].add(new Node(u, w));
        }

        // X에서 각 학생의 집까지 걸리는 최단 시간
        dijkstra(X);

        // 각 학생의 집에서 X까지 걸리는 최단 시간
        dijkstra_reverse(X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, time[i] + time_reverse[i]);
        }

        System.out.println(max);
    }

    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        time[start] = 0;

        while (!pq.isEmpty()) {
            Node n = pq.poll();

            for (Node next : graph[n.idx]) {
                if (time[next.idx] > time[n.idx] + next.t) {
                    time[next.idx] = time[n.idx] + next.t;
                    pq.add(new Node(next.idx, time[next.idx]));
                }
            }
        }
    }

    private static void dijkstra_reverse(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        time_reverse[start] = 0;

        while (!pq.isEmpty()) {
            Node n = pq.poll();

            for (Node next : reverse[n.idx]) {
                if (time_reverse[next.idx] > time_reverse[n.idx] + next.t) {
                    time_reverse[next.idx] = time_reverse[n.idx] + next.t;
                    pq.add(new Node(next.idx, time_reverse[next.idx]));
                }
            }
        }
    }
}
