import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_14500 {

    static int N, M;
    static int[][] paper;
    static int max;

    static int[][] type1 = { { 1, 1, 1, 1 } };
    static int[][] type2 = { { 1, 1 }, { 1, 1 } };
    static int[][] type3 = { { 1, 0 }, { 1, 0 }, { 1, 1 } };
    static int[][] type4 = { { 1, 0 }, { 1, 1 }, { 0, 1 } };
    static int[][] type5 = { { 1, 1, 1 }, { 0, 1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int type = 1; type <= 5; type++) {
            tetromino(type);
        }

        System.out.println(max);
    }

    private static void tetromino(int type) {

        if (type == 1) { // 하늘색

            put(type1);
            put(rotate(type1)); // 90도 회전

        } else if (type == 2) { // 노랑색

            put(type2);

        } else if (type == 3) { // 주황색

            put(type3);
            put(mirror(type3));

            int[][] rotated90 = rotate(type3); // 90도 회전, 대칭
            put(rotated90);
            put(mirror(rotated90));

            int[][] rotated180 = rotate(rotated90); // 180도 회전, 대칭
            put(rotated180);
            put(mirror(rotated180));

            int[][] rotated270 = rotate(rotated180); // 270도 회전, 대칭
            put(rotated270);
            put(mirror(rotated270));

        } else if (type == 4) { // 초록색

            put(type4);
            put(mirror(type4));

            put(rotate(type4));
            put(mirror(rotate(type4)));

        } else if (type == 5) { // 분홍색

            put(type5);

            int[][] rotated90 = rotate(type5); // 90도 회전
            put(rotated90);

            int[][] rotated180 = rotate(rotated90); // 180도 회전
            put(rotated180);

            int[][] rotated270 = rotate(rotated180); // 270도 회전
            put(rotated270);

        }
    }

    private static int[][] rotate(int[][] shape) { // 90도 반시계방향 회전

        int r = shape.length;
        int c = shape[0].length;

        int[][] rotated = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                rotated[i][j] = shape[j][c - i - 1];
            }
        }

        return rotated;
    }

    private static int[][] mirror(int[][] shape) { // 좌우 대칭

        int r = shape.length;
        int c = shape[0].length;

        int[][] mirrored = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mirrored[i][j] = shape[i][c - j - 1];
            }
        }

        return mirrored;
    }

    private static void put(int[][] shape) {

        int r = shape.length;
        int c = shape[0].length;

        for (int i = 0; i <= N - r; i++) {
            for (int j = 0; j <= M - c; j++) {

                int sum = 0;
                for (int x = 0; x < r; x++) {
                    for (int y = 0; y < c; y++) {
                        if (shape[x][y] == 1) {
                            sum += paper[i + x][j + y];
                        }
                    }
                }
                max = Math.max(max, sum);
            }
        }
    }
}
