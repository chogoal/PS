import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_2146 {

    static int N;
    static int[][] island;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        island = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                island[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (island[i][j] == 1) {
                    color(i, j, num++);
                }
            }
        }

        int min = 201;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (island[i][j] > 1) {
                    min = Math.min(search(i, j), min);
                }
            }
        }

        System.out.println(min - 1);
    }

    // 같은 섬끼리 같은 숫자로 컬러링
    private static void color(int i, int j, int num) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { i, j });
        island[i][j] = num;

        while(!queue.isEmpty()) {
            int[] top = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = top[0] + dx[d];
                int ny = top[1] + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && island[nx][ny] == 1) {
                    queue.offer(new int[] { nx, ny });
                    island[nx][ny] = num;
                }
            }
        }
    }

    // 섬끼리 연결되는 다리 찾기
    private static int search(int i, int j) {

        int color = island[i][j]; // 탐색 출발 섬

        boolean[][] visited = new boolean[N][N]; // 방문체크

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { i, j, 0 });
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] top = queue.poll();

            if (island[top[0]][top[1]] != 0 && island[top[0]][top[1]] != color) {
                return top[2];
            }

            for (int d = 0; d < 4; d++) {
                int nx = top[0] + dx[d];
                int ny = top[1] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && island[nx][ny] != color) {
                        queue.offer(new int[]{ nx, ny, top[2] + 1 });
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return 201;
    }
}
