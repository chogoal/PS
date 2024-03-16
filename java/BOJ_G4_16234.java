import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_16234 {

    static int N, L, R;
    static int[][] country;
    static int[][] newCountry;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        country = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            if (open()) break;
            day++;
        }

        System.out.println(day);
    }

    private static boolean open() {

        newCountry = new int[N][N];
        visited = new boolean[N][N];

        // 조건을 만족하는 모든 국경선 오픈
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        // 인구 이동이 종료된 후, 새로운 인구로 나라 갱신
        boolean isChanged = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (newCountry[i][j] != 0) {
                    country[i][j] = newCountry[i][j];
                    isChanged = true;
                }
            }
        }

        // 인구 이동이 없었다면, 반복 종료
        return !isChanged;
    }

    private static void bfs(int i, int j) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { i, j });
        newCountry[i][j] = -1; // 연합에 포함된 칸 체크
        visited[i][j] = true;

        int uniteSum = country[i][j]; // 연합 인구 수
        int uniteCount = 1; // 연합 칸의 개수

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                int diff = Math.abs(country[cur[0]][cur[1]] - country[nx][ny]);
                if (diff >= L && diff <= R) {
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                    newCountry[nx][ny] = -1;
                    uniteSum += country[nx][ny];
                    uniteCount++;
                }
            }
        }

        // 인접한 국경선 열렸다면, 인구 이동
        int newPop = uniteSum / uniteCount;
        if (uniteCount == 1) newPop = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (newCountry[r][c] == -1) {
                    newCountry[r][c] = newPop;
                }
            }
        }
    }
}
