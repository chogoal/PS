import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_17141 {

    static int N, M;
    static int[][] map;
    static int blank; // 벽이 아닌 칸 개수
    static List<int[]> virus = new ArrayList<>(); // 바이러스를 놓을 수 있는 칸
    static int min = Integer.MAX_VALUE; // 바이러스가 퍼지는 최소 시간

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 2][N + 2];
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                map[i][j] = 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 1) blank++;
                if (map[i][j] == 2) virus.add(new int[] { i, j });
            }
        }

        putVirus(0, 0, new int[M]);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void putVirus(int cnt, int idx, int[] selected) {

        if (cnt == M) {
            bfs(selected);
            return;
        }

        for (int i = idx; i < virus.size(); i++) {
            selected[cnt] = i;
            putVirus(cnt + 1, i + 1, selected);
        }
    }

    private static void bfs(int[] selected) {

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N + 2][N + 2];

        for (int idx : selected) {
            int[] pos = virus.get(idx);
            queue.offer(pos);
            visited[pos[0]][pos[1]] = true;
        }

        int time = 0;
        int cnt = 0;

        while (!queue.isEmpty() && cnt < blank - M) {

            time++;
            if (min < time) return;

            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (map[nx][ny] == 1 || visited[nx][ny]) continue;

                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }

        if (cnt == blank - M) min = Math.min(min, time);
    }
}
