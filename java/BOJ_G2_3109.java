import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G2_3109 {

    static int R, C;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dxy = {{ -1, 1 }, { 0, 1 }, { 1, 1 }};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = line.charAt(j);
                map[i][j] = c == '.' ? 0 : 1;
            }
        }

        for (int i = 0; i < R; i++) {
            dfs(i, 0);
        }

        System.out.println(cnt);
    }

    private static boolean dfs(int x, int y) {

        visited[x][y] = true;

        if (y == C - 1) {
            cnt++;
            return true;
        }

        for (int d = 0; d < dxy.length; d++) {
            int nx = x + dxy[d][0];
            int ny = y + dxy[d][1];
            if (nx < 0 || nx >= R || ny >= C || visited[nx][ny]) continue;

            if (map[nx][ny] == 0) {
                if (dfs(nx, ny)) return true;
            }
        }

        return false;
    }
}
