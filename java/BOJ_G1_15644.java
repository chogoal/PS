import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G1_15644 {

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;

    static int[] dx = { 0, 1, 0, -1 }; // RDLU
    static int[] dy = { 1, 0, -1, 0 };
    static char[] dir = { 'R', 'D', 'L', 'U' };

    static int min = Integer.MAX_VALUE;
    static String history = "";

    static class State {
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;
        String history;

        public State(int rx, int ry, int bx, int by, int cnt, String history) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
            this.history = history;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);

                if (board[i][j] == 'R') { rx = i; ry = j; board[i][j] = '.'; }
                if (board[i][j] == 'B') { bx = i; by = j; board[i][j] = '.'; }
            }
        }

        move(rx, ry, bx, by);

        sb.append(min == Integer.MAX_VALUE ? -1 : min).append("\n").append(history);
        System.out.println(sb.toString());
    }

    private static void move(int rx, int ry, int bx, int by) {

        Queue<State> queue = new ArrayDeque<State>();
        queue.offer(new State(rx, ry, bx, by, 0, ""));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {

            State state = queue.poll();

            if (state.cnt >= 10) {
                return;
            }

            for (int d = 0; d < 4; d++) {

                // 빨간공
                int rm = 0;
                rx = state.rx; ry = state.ry;
                while (board[rx + dx[d]][ry + dy[d]] != '#') {
                    rx += dx[d];
                    ry += dy[d];
                    rm++;
                    if (board[rx][ry] == 'O') break;
                }

                // 파란공
                int bm = 0;
                bx = state.bx; by = state.by;
                while (board[bx + dx[d]][by + dy[d]] != '#') {
                    bx += dx[d];
                    by += dy[d];
                    bm++;
                    if (board[bx][by] == 'O') break;
                }

                if (board[bx][by] == 'O') continue;

                if (board[rx][ry] == 'O') {
                    if (min > state.cnt) {
                        min = state.cnt + 1;
                        history = state.history + dir[d];
                        return;
                    }
                }

                if (rx == bx && ry == by) {
                    if (rm > bm) {
                        rx -= dx[d]; ry -= dy[d];
                    } else {
                        bx -= dx[d]; by -= dy[d];
                    }
                }

                if (!visited[rx][ry][bx][by]) {
                    queue.offer(new State(rx, ry, bx, by, state.cnt + 1, state.history + dir[d]));
                    visited[rx][ry][bx][by] = true;
                }
            }
        }
    }
}
