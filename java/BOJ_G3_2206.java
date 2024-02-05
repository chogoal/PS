import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_2206 {

    static int N, M;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int min = Integer.MAX_VALUE;

    static class Point {
        int i;
        int j;
        int count;
        boolean isCrash;

        public Point(int i, int j, int count, boolean isCrash) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.isCrash = isCrash;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void bfs() {

        Queue<Point> queue = new ArrayDeque<Point>();
        queue.offer(new Point(0, 0, 1, false));
        visited[0][0][0] = 1; // 방문 체크

        while (!queue.isEmpty()) {
            Point top = queue.poll();

            if (top.i == N - 1 && top.j == M - 1) { // 1x1 예외
                min = Math.min(min, top.count);
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = top.i + dx[d];
                int ny = top.j + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        if (top.isCrash && visited[1][nx][ny] == 0) {
                            visited[1][nx][ny] = 1;
                            queue.offer(new Point(nx, ny, top.count + 1, top.isCrash));
                        } else if (!top.isCrash && visited[0][nx][ny] == 0) {
                            visited[0][nx][ny] = 1;
                            queue.offer(new Point(nx, ny, top.count + 1, top.isCrash));
                        }
                    } else if (map[nx][ny] == 1 && !top.isCrash) {
                        visited[1][nx][ny] = 1;
                        queue.offer(new Point(nx, ny, top.count + 1, true));
                    }
                }
            }
        }
    }
}
