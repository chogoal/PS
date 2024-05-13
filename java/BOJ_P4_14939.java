import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_P4_14939 {

    static boolean[][] map = new boolean[10][10];
    static int[] dx = { 0, -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 0, -1, 1 };
    static int min = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                char c = line.charAt(j);
                if (c == 'O') map[i][j] = true;
            }
        }

        light(0, 0, 0);

        System.out.println(min == 101 ? -1 : min);
    }

    private static void light(int x, int y, int cnt) {

        if (y == 10) {
            if (x == 9) {
                int sum = 0;
                for (int j = 0; j < 10; j++) {
                    if (map[x][j]) sum++;
                }
                if (sum == 0) min = Math.min(min, cnt);

                return;
            }

            x += 1;
            y = 0;
        }

        boolean[][] mapCopy = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mapCopy[i][j] = map[i][j];
            }
        }

        if (x == 0) { // 첫번째 줄

            // 스위치 누르기
            turn(x, y);
            light(x, y + 1, cnt + 1);

            // 원복
            turn(x, y);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    map[i][j] = mapCopy[i][j];
                }
            }
            light(x, y + 1, cnt);

        } else { // 2 ~ 10번째 줄
            if (map[x - 1][y]) { // 윗줄에 불이 켜져 있으면, 무조건 스위치 누르기
                turn(x, y);
                light(x, y + 1, cnt + 1);
            } else {
                light(x, y + 1, cnt);
            }
        }
    }

    private static void turn(int x, int y) {

        for (int d = 0; d < 5; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;

            map[nx][ny] = !map[nx][ny];
        }
    }
}
