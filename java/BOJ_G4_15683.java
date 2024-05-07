import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G4_15683 {

    static int N, M;
    static int[][] map;
    static List<int[]> cctv;
    static int[] selected;
    static int[][][] dir = {
            {{ 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }},
            {{ 1, 1, 0, 0 }, { 0, 0, 1, 1 }},
            {{ 1, 0, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 0, 1, 1, 0 }},
            {{ 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 0 }, { 0, 1, 1, 1 }},
            {{ 1, 1, 1, 1 }} };
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctv.add(new int[] { i, j, map[i][j] });
                }
            }
        }

        selected = new int[cctv.size()];
        rotate(0);

        System.out.println(min);
    }

    private static void rotate(int cnt) {

        if (cnt == cctv.size()) {
            min = Math.min(min, watch());
            return;
        }

        int type = cctv.get(cnt)[2] - 1;

        for (int i = 0; i < dir[type].length; i++) {
            selected[cnt] = i;
            rotate(cnt + 1);
        }
    }

    private static int watch() {

        int[][] mapCopy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mapCopy[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < selected.length; i++) {
            int x = cctv.get(i)[0];
            int y = cctv.get(i)[1];
            int t = cctv.get(i)[2] - 1;
            int d = selected[i];

            int up = dir[t][d][0];
            int down = dir[t][d][1];
            int left = dir[t][d][2];
            int right = dir[t][d][3];

            if (up == 1) {
                for (int r = x; r >= 0; r--) {
                    if (map[r][y] == 6) break;
                    if (map[r][y] == 0) mapCopy[r][y] = -1;
                }
            }

            if (down == 1) {
                for (int r = x; r < N; r++) {
                    if (map[r][y] == 6) break;
                    if (map[r][y] == 0) mapCopy[r][y] = -1;
                }
            }

            if (left == 1) {
                for (int c = y; c >= 0; c--) {
                    if (map[x][c] == 6) break;
                    if (map[x][c] == 0) mapCopy[x][c] = -1;
                }
            }

            if (right == 1) {
                for (int c = y; c < M; c++) {
                    if (map[x][c] == 6) break;
                    if (map[x][c] == 0) mapCopy[x][c] = -1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j= 0; j < M; j++) {
                if (mapCopy[i][j] == 0) sum++;
            }
        }

        return sum;
    }
}
