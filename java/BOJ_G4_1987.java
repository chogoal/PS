import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1987 {

    static int R, C;
    static char[][] map;
    static boolean[] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean['Z' - 'A' + 1];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int x, int y, int cnt) {

        visited[map[x][y] - 'A'] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (visited[map[nx][ny] - 'A']) continue;

            dfs(nx, ny, cnt + 1);
        }

        max = Math.max(max, cnt);
        visited[map[x][y] - 'A'] = false;
    }
}
