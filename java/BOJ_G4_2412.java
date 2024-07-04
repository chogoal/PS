import java.io.*;
import java.util.*;

public class BOJ_G4_2412 {

    static int n, T;
    static List<Pos>[] graph;

    static class Pos {
        int y;
        boolean visited;

        public Pos(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        graph = new ArrayList[1000001];
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(new Pos(y));
        }

        System.out.println(move());
    }

    private static int move() {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0, 0, 0 });

        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int depth = cur[2];

            if (y == T) {
                cnt = depth;
                break;
            }

            for (int i = x - 2; i <= x + 2; i++) {
                if (i < 0 || i > 1000001) continue;

                for (Pos p : graph[i]) {
                    if (Math.abs(y - p.y) > 2 || p.visited) continue;

                    queue.offer(new int[] { i, p.y, depth + 1 });
                    p.visited = true;
                }
            }
        }

        return cnt == 0 ? -1 : cnt;
    }
}
