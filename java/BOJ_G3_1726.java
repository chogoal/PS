import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_1726 {

    static int M, N;
    static int[][] map;
    static boolean[][][] visited;
    static int[] start, end;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    static class Pos {
        int x;
        int y;
        int dir;
        int cnt;

        public Pos(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N][4];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        start = new int[3];
        end = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            start[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            end[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        System.out.println(move());
    }

    private static int move() {

        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(start[0], start[1], start[2], 0));
        visited[start[0]][start[1]][start[2]] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            if (now.x == end[0] && now.y == end[1] && now.dir == end[2]) {
                return now.cnt;
            }

            // 명령 1. Go k
            for (int k = 1; k <= 3; k++) {
                int nx = now.x + dx[now.dir] * k;
                int ny = now.y + dy[now.dir] * k;
                if (nx < 0 || nx >= M || ny < 0 || ny >= N || map[nx][ny] == 1) break;
                if (visited[nx][ny][now.dir]) continue;

                queue.offer(new Pos(nx, ny, now.dir, now.cnt + 1));
                visited[nx][ny][now.dir] = true;
            }

            // 명령 2. Turn dir
            int left = turnLeft(now.dir);
            if (!visited[now.x][now.y][left]) {
                queue.offer(new Pos(now.x, now.y, left, now.cnt + 1));
                visited[now.x][now.y][left] = true;
            }

            int right = turnRight(now.dir);
            if (!visited[now.x][now.y][right]) {
                queue.offer(new Pos(now.x, now.y, right, now.cnt + 1));
                visited[now.x][now.y][right] = true;
            }
        }

        return -1;
    }

    private static int turnLeft(int d) {
        if (d == 0) return 3;
        if (d == 1) return 2;
        if (d == 2) return 0;
        if (d == 3) return 1;
        return -1;
    }

    private static int turnRight(int d) {
        if (d == 0) return 2;
        if (d == 1) return 3;
        if (d == 2) return 1;
        if (d == 3) return 0;
        return -1;
    }
}
