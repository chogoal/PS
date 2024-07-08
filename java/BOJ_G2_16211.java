import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G2_16211 {

    static int N, M, K;
    static List<Node>[] graph;
    static int[] fan;
    static int[] star;

    static class Node implements Comparable<Node> {
        int idx;
        int t;

        public Node(int idx, int t) {
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
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        fan = new int[N + 1];
        star = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            fan[i] = Integer.MAX_VALUE;
            star[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        // 추종자들의 최소 이동 시간
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            dijkstra(Integer.parseInt(st.nextToken()));
        }

        // 백채원의 최소 이동 시간
        baek();

        for (int i = 2; i <= N; i++) {
            if (star[i] < fan[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.length() == 0 ? 0 : sb.toString());
    }

    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        fan[start] = 0;

        while (!pq.isEmpty()) {
            Node n = pq.poll();

            for (Node next : graph[n.idx]) {
                if (fan[next.idx] > fan[n.idx] + next.t) {
                    fan[next.idx] = fan[n.idx] + next.t;
                    pq.offer(new Node(next.idx, fan[next.idx]));
                }
            }
        }
    }

    private static void baek() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        star[1] = 0;

        while (!pq.isEmpty()) {
            Node n = pq.poll();

            for (Node next : graph[n.idx]) {
                if (star[next.idx] > star[n.idx] + next.t) {
                    star[next.idx] = star[n.idx] + next.t;
                    pq.offer(new Node(next.idx, star[next.idx]));
                }
            }
        }
    }
}
