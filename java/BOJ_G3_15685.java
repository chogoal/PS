import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G3_15685 {

    static int[][] map = new int[101][101];
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken()); // 시작점
            int x = Integer.parseInt(st.nextToken()); // 시작점
            int d = Integer.parseInt(st.nextToken()); // 시작방향 (우상좌하)
            int g = Integer.parseInt(st.nextToken()); // 세대

            curve(x, y, d, g);
        }

        System.out.println(count());
    }

    private static void curve(int x, int y, int d, int g) {

        List<Integer> list = new ArrayList<Integer>();

        // 0세대
        map[x][y] = 1;
        list.add(d);

        // 1 ~ g세대
        for (int i = 0; i < g; i++) {
            // 리스트의 각 점의 방향을 계산해서 리스트에 넣기
            int size = list.size();
            for (int j = 0; j < size; j++) {
                int dir = (list.get(size - 1 - j) + 1) % 4;
                list.add(dir);
            }
        }

        // 모든 세대 종료 후
        for (int i = 0; i < list.size(); i++) {
            int dir = list.get(i);
            x += dx[dir];
            y += dy[dir];
            map[x][y] = 1;
        }
    }

    private static int count() {

        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i][j + 1] == 1 &&
                    map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) cnt++;
            }
        }

        return cnt;
    }
}
