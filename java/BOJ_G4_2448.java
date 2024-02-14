import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G4_2448 {

    static int[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        stars = new int[N][2 * N - 1];

        recur(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < stars[0].length; j++) {
                if (stars[i][j] == 1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void recur(int r, int c, int size) {

        if (size == 3) {
            stars[r][c] = 1;

            stars[r + 1][c - 1] = 1;
            stars[r + 1][c + 1] = 1;

            stars[r + 2][c - 2] = 1;
            stars[r + 2][c - 1] = 1;
            stars[r + 2][c] = 1;
            stars[r + 2][c + 1] = 1;
            stars[r + 2][c + 2] = 1;
            return;
        }

        int newSize = size / 2;
        recur(r, c, newSize);
        recur(r + newSize, c - newSize, newSize);
        recur(r + newSize, c + newSize, newSize);
    }
}
