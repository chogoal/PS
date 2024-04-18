import java.io.*;
import java.util.*;

public class BOJ_G3_17142 {

    static int N, M;
    static int[][] map;
    static int empty;
    static List<int[]> virus;
    static int min = Integer.MAX_VALUE;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) empty++;
                if (map[i][j] == 2) virus.add(new int[] { i, j });
            }
        }

        active(0, 0, new int[M]);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void active(int cnt, int idx, int[] selected) {

        if (cnt == M) {
            bfs(selected);
            return;
        }

        for (int i = idx; i < virus.size(); i++) {
            selected[cnt] = i;
            active(cnt + 1, i + 1, selected);
        }
    }

    private static void bfs(int[] selected) {

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int idx : selected) {
            int[] pos = virus.get(idx);
            queue.offer(pos);
            visited[pos[0]][pos[1]] = true;
        }

        int time = 0;
        int virus = 0;

        while (!queue.isEmpty() && virus < empty) {

            time++;
            if (time > min) return;

            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (map[nx][ny] == 1 || visited[nx][ny]) continue;

                    if (map[nx][ny] == 0) virus++;
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                }
            }
        }

        if (virus == empty) min = Math.min(min, time);
    }
}
