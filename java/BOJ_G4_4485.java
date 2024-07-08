import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_4485 {

    static int N;
    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int k;

        public Node (int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }

        public int compareTo(Node o) {
            return this.k - o.k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; ; t++) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(t).append(": ").append(bfs()).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int bfs() {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0, 0 });

        int[][] visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[0][0] = map[0][0];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (visited[nx][ny] > visited[x][y] + map[nx][ny]) {
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = visited[x][y] + map[nx][ny];
                }
            }
        }

        return visited[N - 1][N - 1];
    }
}
