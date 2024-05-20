import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_23880 {

    static int N, K;
    static int[][] map;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            dp = new int[N][N][2][K + 1];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    char c = line.charAt(j);
                    if (c == '.') map[i][j] = 0;
                    else map[i][j] = 1;

                    for (int k = 0; k < 2; k++) {
                        Arrays.fill(dp[i][j][k], -1);
                    }
                }
            }

            sb.append(move(0, 1, 0, 0) + move(1, 0, 1, 0)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int move(int x, int y, int prev, int dir) {

        if (x >= N || y >= N || map[x][y] == 1 || dir > K) return 0;

        if (y == N - 1 && x == N - 1) return 1;

        if (dp[x][y][prev][dir] != -1) return dp[x][y][prev][dir];

        int count = 0;
        if (prev == 1) {
            count += move(x + 1, y, 1, dir);
            count += move(x, y + 1, 0, dir + 1);
        } else {
            count += move(x, y + 1, 0, dir);
            count += move(x + 1, y, 1, dir + 1);
        }

        dp[x][y][prev][dir] = count;
        return dp[x][y][prev][dir];
    }
}
