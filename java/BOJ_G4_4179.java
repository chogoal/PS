import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_4179 {

    static int R, C;
    static char[][] maze;
    static Queue<int[]> jihoon = new ArrayDeque<>();
    static Queue<int[]> fire = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maze = new char[R + 2][C + 2];
        for (int i = 0; i < R + 2; i++) {
            Arrays.fill(maze[i], '*');
        }

        for (int i = 1; i <= R; i++) {
            String s = br.readLine();
            for (int j = 1; j <= C; j++) {
                maze[i][j] = s.charAt(j - 1);
                if (maze[i][j] == 'J') {
                    jihoon.offer(new int[] { i, j });
                    maze[i][j] = '-';
                } else if (maze[i][j] == 'F') {
                    fire.offer(new int[] { i, j });
                }
            }
        }

        int result = bfs();
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    private static int bfs () {

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        int time = 0;

        while (true) {

            // 불의 이동
            int fireRange = fire.size();
            while (fireRange-- > 0) {
                int[] top = fire.poll();

                for (int d = 0; d < 4; d++) {
                    int fireX = top[0] + dx[d];
                    int fireY = top[1] + dy[d];
                    if (fireX >= 1 && fireX < R + 1 && fireY >= 1 && fireY < C + 1) {
                        if (maze[fireX][fireY] == '.' || maze[fireX][fireY] == '-' || maze[fireX][fireY] == 'J') {
                            fire.offer(new int[] { fireX, fireY });
                            maze[fireX][fireY] = 'F';
                        }
                    }
                }
            }

            // 지훈이의 이동
            int jihoonRange = jihoon.size();
            while (jihoonRange-- > 0) {
                int[] cur = jihoon.poll();

                for (int d = 0; d < 4; d++) {
                    int nextX = cur[0] + dx[d];
                    int nextY = cur[1] + dy[d];
                    if (nextX >= 0 && nextX < R + 2 && nextY >= 0 && nextY < C + 2) {
                        if (maze[nextX][nextY] == '*') {
                            return ++time;
                        } else if (maze[nextX][nextY] == '.') {
                            jihoon.offer(new int[] { nextX, nextY });
                            maze[nextX][nextY] = '-';
                        }
                    }
                }
            }

            if (jihoon.isEmpty()) { // 지훈이가 갈 수 있는 길이 없다면
                break;
            }
            time++;
        }

        // 지훈이가 탈출하지 못한 경우
        return -1;
    }
}
