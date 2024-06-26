import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_S1_2667 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int cnt = 0;
        List<Integer> houseCnt = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt++;

                    house = 0;
                    dfs(i, j);
                    houseCnt.add(house);
                }
            }
        }

        Collections.sort(houseCnt);

        sb.append(cnt).append("\n");
        for (int h : houseCnt) sb.append(h).append("\n");
        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y) {

        visited[x][y] = true;
        house++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

            if (map[nx][ny] == 1) dfs(nx, ny);
        }
    }
}
