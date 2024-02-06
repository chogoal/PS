import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_1600 {

    static int K, W, H;
    static int[][] map;
    static int[][][] visited;
    static int[][] monkeyMove = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    static int[][] horseMove = { {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1} };

    static class Point {
        int i;
        int j;
        int count; // 동작 수
        int horse; // 말처럼 움직인 동작 수

        public Point(int i, int j, int count, int horse) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.horse = horse;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new int[K + 1][H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        Queue<Point> queue = new ArrayDeque<Point>();
        queue.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            if (now.i == H - 1 && now.j == W - 1) {
                return now.count;
            }

            // 원숭이의 움직임으로 갈 수 있는 곳
            for (int d = 0; d < 4; d++) {
                int nx = now.i + monkeyMove[d][0];
                int ny = now.j + monkeyMove[d][1];
                if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0) {
                    if (visited[now.horse][nx][ny] == 0) {
                        queue.offer(new Point(nx, ny, now.count + 1, now.horse));
                        visited[now.horse][nx][ny] = 1;
                    }
                }
            }

            // 말의 움직임으로 갈 수 있는 곳
            if (now.horse < K) {
                for (int d = 0; d < 8; d++) {
                    int nx = now.i + horseMove[d][0];
                    int ny = now.j + horseMove[d][1];
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0) {
                        if (visited[now.horse + 1][nx][ny] == 0) {
                            queue.offer(new Point(nx, ny, now.count + 1, now.horse + 1));
                            visited[now.horse + 1][nx][ny] = 1;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
