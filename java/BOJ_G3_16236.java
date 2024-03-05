import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G3_16236 {

    static int N;
    static int[][] area; // 9: 아기 상어, 1~6: 물고기(크기)
    static int fish; // 물고기 수
    static Shark shark; // 아기상어

    static int[] dx = { -1, 0, 0, 1 }; // 상좌우하
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

    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {

            if (this.dist == o.dist) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.dist - o.dist;
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
                else if (area[i][j] >= 1 && area[i][j] <= 6) { fish++; }
            }
        }

        System.out.println(move());
    }

    private static int move() {

        int time = 0;

        while (true) {

            if (fish == 0) break;

            // 이동 경로 저장
            Queue<int[]> queue = new ArrayDeque<int[]>();
            queue.offer(new int[] { shark.x, shark.y, 0 });

            // 방문 체크
            boolean[][] visited = new boolean[N][N];
            visited[shark.x][shark.y] = true;

            // 현재 위치에서 먹을 수 있는 물고기 찾기
            // - 아기 상어보다 작은 크기의 물고기 (= 먹을 수 있음)
            // - 아기 상어와 같은 크기의 물고기 (= 먹을 수 없지만 지나갈 수 있음)
            // - 아기 상어보다 큰 크기의 물고기 (= 지나갈 수 없음)
            ArrayList<Fish> targetList = new ArrayList<Fish>();
            boolean isTarget = false;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                    int check = area[nx][ny];
                    if (check == 0 || check == shark.size) {
                        queue.offer(new int[] { nx, ny, now[2] + 1 });
                        visited[nx][ny] = true;
                    } else if (check < shark.size) {
                        targetList.add(new Fish(nx, ny, now[2] + 1));
                        isTarget = true;
                    }
                }
            }



            // 물고기 먹기
            if (isTarget) {

                // 가장 위쪽의 가장 왼쪽에 위치한 물고기 찾기
                Collections.sort(targetList);
                Fish target = targetList.get(0);

                shark.x = target.x; shark.y = target.y;
                shark.eat();
                fish--;
                area[target.x][target.y] = 0;
                time += target.dist;
            } else {
                break;
            }
        }

        return time;
    }
}
