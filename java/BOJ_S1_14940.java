import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_14940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[] goal = new int[2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    goal = new int[] {i, j};
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<int[]>();
        int[][] distance = new int[n][m];
        int[] dx = new int[] { 0, 1, 0, -1 };
        int[] dy = new int[] { 1, 0, -1, 0 };

        queue.offer(goal);
        distance[goal[0]][goal[1]] = 1; // 방문 여부 표시

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int dist = distance[curX][curY];

            for (int d = 0; d < 4; d++) {
                int nextX = curX + dx[d];
                int nextY = curY + dy[d];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (map[nextX][nextY] == 1 && distance[nextX][nextY] == 0) {
                        queue.offer(new int[] {nextX, nextY});
                        distance[nextX][nextY] = dist + 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) { // 목표 지점
                    sb.append("0 ");
                } else if (map[i][j] == 1) { // 방문 가능한 땅
                    if (distance[i][j] == 0) {
                        sb.append("-1 ");
                    } else {
                        sb.append(distance[i][j] - 1).append(" ");
                    }
                } else if (map[i][j] == 0) { // 원래 방문 불가
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
