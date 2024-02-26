import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_14503 {

    static int N, M;
    static int[][] room; // 처음 빈 칸(0)은 모두 청소되지 않은 상태
    static boolean[][] cleaned; // 청소한 칸

    static int dir;
    static int[] robot; // r, c
    static int[] dx = { -1, 0, 1, 0 }; // 북서남동 (반시계)
    static int[] dy = { 0, -1, 0, 1 }; // 북서남동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        cleaned = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        robot = new int[2];
        robot[0] = Integer.parseInt(st.nextToken());
        robot[1] = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        if (dir == 1) dir = 3;
        else if (dir == 3) dir = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cleaned[i][j]) count++;
            }
        }

        System.out.println(count);
    }

    private static void move() {

        while (true) {

            int r = robot[0];
            int c = robot[1];

            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸 청소
            if (!cleaned[r][c]) cleaned[r][c] = true;

            // 현재 칸의 주변 4칸 탐색 (반시계 방향)
            boolean bincan = false; // 빈칸 유무
            for (int d = 1; d <= 4; d++) {
                int nx = r + dx[(dir + d) % 4];
                int ny = c + dy[(dir + d) % 4];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (room[nx][ny] == 1 || cleaned[nx][ny]) continue;

                // 빈 칸 있는 경우
                bincan = true;
                robot[0] = nx; robot[1] = ny;
                dir = (dir + d) % 4;
                break;
            }

            if (bincan) continue;

            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            int nx = r + dx[(dir + 2) % 4];
            int ny = c + dy[(dir + 2) % 4];

            // 벽이라 후진할 수 없다면 작동 중지
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || room[nx][ny] == 1) break;

            // 후진할 수 있다면 한 칸 후진
            robot[0] = nx; robot[1] = ny;
        }
    }
}
