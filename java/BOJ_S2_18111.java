import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_18111 {

    static int N, M, B;
    static int[][] ground;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        ground = new int[N][M];
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if (maxHeight < ground[i][j]) {
                    maxHeight = ground[i][j];
                }
            }
        }

        int[] result;
        int time = Integer.MAX_VALUE;
        int height = 0;

        for (int i = 0; i <= maxHeight; i++) {
            result = cal(i);

            if (result[0] == -1) continue;

            if (result[0] < time) { // 최소 시간 찾기
                time = result[0];
                height = result[1];
            } else if (result[0] == time && result[1] > height) { // 최대 높이 찾기
                time = result[0];
                height = result[1];
            }
        }

        sb.append(time).append(" ").append(height);
        System.out.println(sb.toString());
    }

    private static int[] cal(int height) { // height 높이로 땅을 평탄화

        int t = 0;
        int block = B;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ground[i][j] < height) {
                    block -= height - ground[i][j];
                    t += height - ground[i][j];
                } else if (ground[i][j] > height) {
                    block += ground[i][j] - height;
                    t += (ground[i][j] - height) * 2;
                }
            }
        }

        if (block < 0) { // 불가능
            return new int[] { -1, -1 };
        }

        return new int[] { t, height };
    }
}
