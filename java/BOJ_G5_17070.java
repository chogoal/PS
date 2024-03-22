import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_17070 {

    static int N;
    static int[][] map;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            map[N][i] = 1;
            map[i][N] = 1;
        }
        map[N][N] = 1;

        dfs(0, 1, 0);

        System.out.println(count);
    }

    private static void dfs(int r, int c, int dir) {

        if (r == N - 1 && c == N - 1) {
            count++;
            return;
        }

        switch (dir) {
            case 0:
                if (map[r][c + 1] == 0) {
                    dfs(r, c + 1, 0);
                }
                if (map[r + 1][c] == 0 && map[r + 1][c + 1] == 0 && map[r][c + 1] == 0) {
                    dfs(r + 1, c + 1, 2);
                }
                break;
            case 1:
                if (map[r + 1][c] == 0) {
                    dfs(r + 1, c, 1);
                }
                if (map[r + 1][c] == 0 && map[r + 1][c + 1] == 0 && map[r][c + 1] == 0) {
                    dfs(r + 1, c + 1, 2);
                }
                break;
            case 2:
                if (map[r][c + 1] == 0) {
                    dfs(r, c + 1, 0);
                }
                if (map[r + 1][c] == 0) {
                    dfs(r + 1, c, 1);
                }
                if (map[r + 1][c] == 0 && map[r + 1][c + 1] == 0 && map[r][c + 1] == 0) {
                    dfs(r + 1, c + 1, 2);
                }
                break;
        }
    }
}
