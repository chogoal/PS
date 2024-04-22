import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_20057 {

    static int N;
    static int[][] map;
    static int[] dx = { 0, 1, 0, -1 }; // 좌하우상
    static int[] dy = { -1, 0, 1, 0 };
    static int[] sandRate = { 2, 10, 7, 1, 5, 10, 7, 1, 2 };
    static int[][] sandDx = {
            { -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 },
            { 0, 1, 0, -1, 2, 1, 0, -1, 0, 1 },
            { -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 },
            { 0, -1, 0, 1, -2, -1, 0, 1, 0, -1 } };
    static int[][] sandDy = {
            { 0, -1, 0, 1, -2, -1, 0, 1, 0, -1 },
            { -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 },
            { 0, 1, 0, -1, 2, 1, 0, -1, 0, 1 },
            { 2, 1, 1, 1, 0, -1, -1, -1, -2, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int sand = 0; // 처음 격자 안 모래의 양
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sand += map[i][j];
            }
        }

        tornado();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sand - sum);
    }

    private static void tornado() {

        int x = N / 2, y = N / 2;
        int dir = 0; // 진행방향
        int cnt = 1; // 같은 방향으로 진행한 칸 수
        int turn = 0; // 같은 cnt 만큼 이동한 횟수 (2번)

        while (true) {

            int moved = 0;
            while (moved < cnt && !(x == 0 && y == 0)) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (map[nx][ny] != 0) moveSand(nx, ny, dir);

                moved++;
                x = nx; y = ny;
            }

            if (x == 0 && y == 0) break;

            dir = (dir + 1) % 4;
            turn++;

            if (turn == 2) {
                turn = 0;
                cnt++;
            }
        }
    }

    private static void moveSand(int x, int y, int d) {

        int from = map[x][y];

        for (int i = 0; i < 9; i++) {
            int nx = x + sandDx[d][i];
            int ny = y + sandDy[d][i];

            int sand = from * sandRate[i] / 100;
            map[x][y] -= sand;

            if (!inRange(nx, ny)) continue;
            map[nx][ny] += sand;
        }

        int alphaX = x + sandDx[d][9];
        int alphaY = y + sandDy[d][9];
        if (inRange(alphaX, alphaY)) map[alphaX][alphaY] += map[x][y];
        map[x][y] = 0;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
