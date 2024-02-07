import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G1_16933 {

    static int N, M, K;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    static class Point {
        int i;
        int j;
        int count;
        int blocked;

        public Point(int i, int j, int count, int blocked) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.blocked = blocked;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[K + 1][N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        Queue<Point> queue = new ArrayDeque<Point>();
        queue.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            if (now.i == N - 1 && now.j == M - 1) {
                return now.count;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.i + dx[d];
                int ny = now.j + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (map[nx][ny] == 0 && visited[now.blocked][nx][ny] == 0) {
                    queue.offer(new Point(nx, ny, now.count + 1, now.blocked));
                    visited[now.blocked][nx][ny] = 1;
                } else if (map[nx][ny] == 1 && now.blocked < K && visited[now.blocked + 1][nx][ny] == 0) {
                    if (now.count == 0 || now.count % 2 == 1) {
                        queue.offer(new Point(nx, ny, now.count + 1, now.blocked + 1));
                        visited[now.blocked + 1][nx][ny] = 1;
                    } else { // 밤일 경우, 한 번 머무르기
                        queue.offer(new Point(now.i, now.j, now.count + 1, now.blocked));
                    }
                }
            }
        }

        return -1;
    }
}
