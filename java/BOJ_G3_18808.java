import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G3_18808 {

    static int N, M, K;
    static int[][] notebook;
    static ArrayList<int[][]> stickers = new ArrayList<int[][]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        notebook = new int[N][M];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[R][C];

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            stickers.add(sticker);
        }

        for (int i = 0; i < K; i++) {
            post(stickers.get(i));
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j] == 1) count++;
            }
        }

        System.out.println(count);
    }

    public static int[][] rotate(int[][] s) {

        int r = s.length;
        int c = s[0].length;

        int[][] rotated = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                rotated[i][j] = s[r - 1 - j][i];
            }
        }

        return rotated;
    }

    private static void post(int[][] sticker) {

        if (find(sticker)) return;

        int[][] rotated90 = rotate(sticker);
        if (find(rotated90)) return;

        int[][] rotated180 = rotate(rotated90);
        if (find(rotated180)) return;

        int[][] rotated270 = rotate(rotated180);
        find(rotated270);
    }

    private static boolean find(int[][] sticker) {

        int sr = sticker.length;
        int sc = sticker[0].length;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {

                if (x + sr > N || y + sc > M) continue;

                boolean found = true;
                ex:
                for (int i = 0; i < sr; i++) {
                    for (int j = 0; j < sc; j++) {
                        if (sticker[i][j] == 1 && notebook[x + i][y + j] == 1) {
                            found = false;
                            break ex;
                        }
                    }
                }

                if (found) {
                    for (int i = 0; i < sr; i++) {
                        for (int j = 0; j < sc; j++) {
                            if (sticker[i][j] == 1) {
                                notebook[x + i][y + j] = 1;
                            }
                        }
                    }
                    return true;
                }
            }
        }

        return false;
    }
}
