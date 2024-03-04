import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G1_15653 {

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

                if (board[i][j] == 'R') { rx = i; ry = j; board[i][j] = '.'; }
                if (board[i][j] == 'B') { bx = i; by = j; board[i][j] = '.'; }
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

            for (int d = 0; d < 4; d++) {

                // 빨간공 굴리기
                int rm = 0;
                rx = cur[0];
                ry = cur[1];
                while (board[rx + dx[d]][ry + dy[d]] != '#') {
                    rx += dx[d];
                    ry += dy[d];
                    rm++;
                    if (board[rx][ry] == 'O') break;
                }

                // 파란공 굴리기
                int bm = 0;
                bx = cur[2];
                by = cur[3];
                while (board[bx + dx[d]][by + dy[d]] != '#') {
                    bx += dx[d];
                    by += dy[d];
                    bm++;
                    if (board[bx][by] == 'O') break;
                }

                // 파란공이 구멍에 빠졌다면, 다른 방향으로 넘어가기
                if (board[bx][by] == 'O') continue;

                // 빨간공이 구멍에 빠졌다면, 최소 횟수 갱신하고 종료
                if (board[rx][ry] == 'O') {
                    min = Math.min(min, cur[4] + 1);
                    return;
                }

                // 파란공과 빨간공이 구멍이 아닌 곳에 같이 위치해있다면,
                // 더 많이 움직인 공을 한 칸 씩 뒤로 보내기
                if (rx == bx && ry == by) {
                    if (rm > bm) {
                        rx -= dx[d];
                        ry -= dy[d];
                    } else {
                        bx -= dx[d];
                        by -= dy[d];
                    }
                }

                // 현재 위치가 방문한 적 없는 위치라면 큐에 저장
                if (!visited[rx][ry][bx][by]) {
                    queue.offer(new int[]{ rx, ry, bx, by, cur[4] + 1 });
                    visited[rx][ry][bx][by] = true;
                }
            }
        }
    }
}