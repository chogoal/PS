import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G3_16236 {

    static int N;
    static int[][] area; // 9: 아기 상어, 1~6: 물고기(크기)
    static int[] fish = new int[7];
    static Shark shark; // 아기상어
    static int time;

    static int[] dx = { -1, 0, 0, 1 };
    static int[] dy = { 0, -1, 1, 0 };

    static class Shark {
        int x;
        int y;
        int size;
        int count; // 먹은 물고기 수

        public Shark(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.count = 0;
        }

        public void eat() {
            count += 1;
            if (count == size) {
                size += 1;
                count = 0;
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {

            if (this.time == o.time) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        area = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());

                if (area[i][j] == 9) { shark = new Shark(i, j, 2); area[i][j] = 0; }
                else if (area[i][j] >= 1 && area[i][j] <= 6) {
                    fish[area[i][j]]++;
                }
            }
        }

        while (move());

        System.out.println(time);
    }

    private static boolean move() {

        if (!fishExist()) return false;

        PriorityQueue<Point> pq = new PriorityQueue<Point>();
        boolean[][] visited = new boolean[N][N];
        pq.add(new Point(shark.x, shark.y, 0));
        visited[shark.x][shark.y] = true;

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            if (area[now.x][now.y] != 0 && area[now.x][now.y] < shark.size) {
                shark.x = now.x; shark.y = now.y;
                shark.eat();
                fish[area[now.x][now.y]]--;
                area[now.x][now.y] = 0;
                time += now.time;
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                if (area[nx][ny] > shark.size) continue;

                pq.add(new Point(nx, ny, now.time + 1));
                visited[nx][ny] = true;
            }
        }
        return false;
    }

    private static boolean fishExist() {

        for (int i = 1; i < Math.min(shark.size, 7); i++) {
            if (fish[i] > 0) return true;
        }
        return false;
    }
}
