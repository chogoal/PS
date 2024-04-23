import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_P4_1090 {

    static int N;
    static int[][] checker;
    static int[] checkerX;
    static int[] checkerY;
    static int[] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        checker = new int[N][2];
        checkerX = new int[N];
        checkerY = new int[N];
        min = new int[N];

        for (int i = 0; i < N; i++) {
            min[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            checker[i][0] = x; checker[i][1] = y;
            checkerX[i] = x;
            checkerY[i] = y;
        }

        move();

        for (int i = 0; i < N; i++) {
            sb.append(min[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void move() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 체커들의 x좌표와 y좌표의 교점 (중앙값 후보)
                int x = checkerX[i];
                int y = checkerY[j];

                // 현재 교점에서 각 체커들까지의 거리
                int[] dist = new int[N];
                for (int k = 0; k < N; k++) {
                    dist[k] = Math.abs(x - checker[k][0]) + Math.abs(y - checker[k][1]);
                }

                // 현재 교점에서 체커들과의 거리 정렬
                Arrays.sort(dist);

                // 현재 교점으로 체커 1~N개를 모이게 할 때, 이동 거리의 합
                int[] sum = new int[N];
                sum[0] = dist[0];
                for (int k = 1; k < N; k++) {
                    sum[k] = sum[k - 1] + dist[k];
                }

                // 이동 거리 합의 최소
                for (int k = 0; k < N; k++) {
                    min[k] = Math.min(min[k], sum[k]);
                }
            }
        }
    }
}
