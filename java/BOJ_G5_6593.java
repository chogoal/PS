import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
딩
public class BOJ_G5_6593 {

    static int L, R, C;
    static char[][][] building;
    static int[][] dir = // 동, 서, 남, 북, 상, 하
            { {0, 0, 1}, {0, 0, -1}, {0, 1, 0},
            {0, -1, 0}, {1, 0, 0}, {-1, 0, 0} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            building = new char[L][R][C];

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            int[] start = new int[3];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = s.charAt(k);
                        if (building[i][j][k] == 'S') {
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        }
                    }
                }
                br.readLine();
            }

            int time = bfs(start[0], start[1], start[2]);
            if (time > 0) {
                sb.append("Escaped in ").append(time).append(" minute(s).\n");
            } else {
                sb.append("Trapped!\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static int bfs(int i, int j, int k) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { i, j, k });
        building[i][j][k] = '#'; // 방문 체크

        int minute = 0;

        while (true) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();

                for (int d = 0; d < dir.length; d++) {
                    int nz = cur[0] + dir[d][0];
                    int ny = cur[1] + dir[d][1];
                    int nx = cur[2] + dir[d][2];

                    if (nx >= 0 && nx < C && ny >= 0 && ny < R && nz >= 0 && nz < L) {
                        if (building[nz][ny][nx] == 'E') {
                            return ++minute;
                        } else if (building[nz][ny][nx] == '.') {
                            queue.offer(new int[] { nz, ny, nx });
                            building[nz][ny][nx] = '#';
                        }
                    }
                }
            }

            if (queue.isEmpty()) {
                return -1;
            }

            minute++;
        }
    }
}
