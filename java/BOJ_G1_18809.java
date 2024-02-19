import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G1_18809 {

    static int N, M, G, R;
    static int max;
    static int[][] ground;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static ArrayList<int[]> list = new ArrayList<int[]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        ground = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if (ground[i][j] == 2) list.add(new int[] { i, j });
            }
        }

        green(0, 0);

        System.out.println(max);
    }

    private static void green(int cnt, int start) {

        // 초록색 배양액을 뿌릴 땅 정해지면 빨간색 배양액 뿌릴 땅 정하기
        if (cnt == G) {
            red(0, 0);
            return;
        }

        // 초록색 배양액(3) 뿌릴 땅 정하기
        for (int i = start; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];

            if (ground[x][y] == 2) {
                ground[x][y] = 3;
                green(cnt + 1, i + 1);
                ground[x][y] = 2;
            }
        }
    }

    private static void red(int cnt, int start) {

        // 빨간색 배양액을 뿌릴 땅 정해지면, 피울 수 있는 꽃 계산
        if (cnt == R) {
            max = Math.max(max, garden());
            return;
        }

        // 빨간색 배양액(4) 뿌릴 땅 정하기
        for (int i = start; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];

            if (ground[x][y] == 2) {
                ground[x][y] = 4;
                red(cnt + 1, i + 1);
                ground[x][y] = 2;
            }
        }
    }

    private static int garden() {

        Queue<int[]> queue = new ArrayDeque<int[]>();

        int[][] garden = new int[N][M];
        int[][] visited = new int[N][M];

        int flowers = 0;
        int time = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ground[i][j] == 3) {
                    queue.offer(new int[] { i, j });
                    garden[i][j] = 3;
                    visited[i][j] = time;
                } else if (ground[i][j] == 4) {
                    queue.offer(new int[] { i, j });
                    garden[i][j] = 4;
                    visited[i][j] = time;
                }
            }
        }

        while (true) {

            time++;

            // 배양액 퍼트리기
            int size = queue.size();
            while(size-- > 0) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                // 꽃이 피어있으면, 다음으로 넘어가기
                if (garden[x][y] == -1) continue;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                    // 물이면 패스
                    if (ground[nx][ny] == 0) continue;

                    // 꽃이면 패스
                    if (garden[nx][ny] == -1) continue;

                    // 같은 배양액인 땅이면 패스
                    if (garden[nx][ny] == garden[x][y]) continue;

                    // 다른 배양액인 땅이고, 시간이 같으면 꽃
                    if (visited[nx][ny] == time && garden[nx][ny] != garden[x][y]) {
                        garden[nx][ny] = -1;
                        flowers++;
                    }

                    // 방문하지 않은 땅이면 큐에 넣기
                    if (visited[nx][ny] == 0) {
                        visited[nx][ny] = time;
                        garden[nx][ny] = garden[x][y];
                        queue.offer(new int[] { nx, ny });
                    }
                }
            }

            if (queue.isEmpty()) break;
        }

        return flowers;
    }
}
