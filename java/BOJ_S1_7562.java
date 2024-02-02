import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_7562 {

    static int l;
    static int[] from = new int[2];
    static int[] to = new int[2];

    static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            l = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            from[0] = Integer.parseInt(st.nextToken());
            from[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            to[0] = Integer.parseInt(st.nextToken());
            to[1] = Integer.parseInt(st.nextToken());

            sb.append(bfs()).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int bfs() {

        if (to[0] == from[0] && to[1] == from[1]) {
            return 0;
        }

        int[][] chess = new int[l][l];
        chess[to[0]][to[1]] = 1; // 목표지점

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(from);
        chess[from[0]][from[1]] = -1; // 나이트 이동 경로

        int count = 0; // 이동 횟수

        while (true) {
            int range = queue.size();
            while (range-- > 0) {
                int[] top = queue.poll();

                for (int d = 0; d < 8; d++) {
                    int nextX = top[0] + dx[d];
                    int nextY = top[1] + dy[d];
                    if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l) {
                        if (chess[nextX][nextY] == 0) {
                            queue.offer(new int[] { nextX, nextY });
                            chess[nextX][nextY] = -1;
                        } else if (chess[nextX][nextY] == 1) {
                            return ++count;
                        }
                    }
                }
            }

            if (queue.isEmpty()) break;
            count++;
        }

        return count;
    }
}
