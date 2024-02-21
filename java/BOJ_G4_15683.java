import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G4_15683 {

    static int N, M;
    static int min;
    static int zero;
    static int[][] office;
    static ArrayList<int[]> cctv = new ArrayList<int[]>();

    // 상, 하, 좌, 우
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][][] cctvDir =
            {
                { {0}, {1}, {2}, {3} },
                { {0, 1}, {2, 3} },
                { {0, 3}, {0, 2}, {1, 2}, {1, 3} },
                { {0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3} },
                { {0, 1, 2, 3} }
            };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());

                if (office[i][j] == 0) zero++;
                else if (office[i][j] != 6) {
                    cctv.add(new int[] { i, j, office[i][j] });
                }
            }
        }

        min = zero;

        perm(0, office);

        System.out.println(min);
    }

    private static void perm(int cnt, int[][] office) {

        if (cnt == cctv.size()) {
            min = Math.min(min, check(office));
            return;
        }

        int cctvType = cctv.get(cnt)[2] - 1;
        int cctvX = cctv.get(cnt)[0];
        int cctvY = cctv.get(cnt)[1];

        for (int i = 0; i < cctvDir[cctvType].length; i++) {

            int[][] watch = new int[N][M];
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    watch[n][m] = office[n][m];
                }
            }

            for (int d = 0; d < cctvDir[cctvType][i].length; d++) {
                int dir = cctvDir[cctvType][i][d];
                int nx = cctvX + dx[dir];
                int ny = cctvY + dy[dir];

                while (true) {
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
                    if (office[nx][ny] == 6) break;

                    watch[nx][ny] = -1;

                    nx += dx[dir];
                    ny += dy[dir];
                }
            }

            perm(cnt + 1, watch);
        }
    }

    private static int check(int[][] watch) {

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (watch[i][j] == 0) count++;
            }
        }

        return count;
    }
}
