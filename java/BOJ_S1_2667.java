import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_S1_2667 {

    static int N;
    static int[][] map;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        ArrayList<Integer> danji = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    count = 1;
                    dfs(new int[] { i, j });
                    danji.add(count);
                }
            }
        }

        Collections.sort(danji);

        sb.append(danji.size()).append("\n");
        for (int i = 0; i < danji.size(); i++) {
            sb.append(danji.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int[] cur) {

        int curX = cur[0];
        int curY = cur[1];
        map[curX][curY] = -1;

        for (int d = 0; d < 4; d++) {
            int nextX = curX + dx[d];
            int nextY = curY + dy[d];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && map[nextX][nextY] == 1) {
                count++;
                dfs(new int[] { nextX, nextY });
            }
        }
    }
}
