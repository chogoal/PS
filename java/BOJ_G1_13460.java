import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G1_13460 {

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);

                if (board[i][j] == 'R') {
                    rx = i; ry = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    bx = i; by = j;
                    board[i][j] = '.';
                }
            }
        }

        move(rx, ry, bx, by);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void move(int rx, int ry, int bx, int by) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { rx, ry, bx, by, 0 });
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            if (cur[4] >= 10) return;

            for (int d = 0; d < 4; d++) {

                // 빨간공 이동
                int rm = 0; // 빨간공 이동 거리
                int rnx = cur[0];
                int rny = cur[1];
                while (board[rnx + dx[d]][rny + dy[d]] != '#') {
                    rnx += dx[d];
                    rny += dy[d];
                    rm++;
                    if (board[rnx][rny] == 'O') break;
                }

                // 파란공 이동
                int bm = 0; // 파란공 이동 거리
                int bnx = cur[2];
                int bny = cur[3];
                while (board[bnx + dx[d]][bny + dy[d]] != '#') {
                    bnx += dx[d];
                    bny += dy[d];
                    bm++;
                    if (board[bnx][bny] == 'O') break;
                }

                if (board[bnx][bny] == 'O') continue;

                if (board[rnx][rny] == 'O') {
                    min = Math.min(min, cur[4] + 1);
                    return;
                }

                if (rnx == bnx && rny == bny && board[rnx][rny] != 'O') {
                    if (rm > bm) {
                        rnx -= dx[d];
                        rny -= dy[d];
                    } else {
                        bnx -= dx[d];
                        bny -= dy[d];
                    }
                }

                if (!visited[rnx][rny][bnx][bny]) {
                    queue.offer(new int[] { rnx, rny, bnx, bny, cur[4] + 1} );
                    visited[rnx][rny][bnx][bny] = true;
                }

            }
        }
    }
}
