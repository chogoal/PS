import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_16945 {

    static int[][] A, square;
    static boolean[] selected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = new int[3][3];
        square = new int[3][3];
        selected = new boolean[9];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        magic(0, 0);

        System.out.println(min);
    }

    private static void magic(int x, int y) {

        if (y == 3) {
            if (x == 2 && check()) {
                min = Math.min(min, cost());
                return;
            }
            x += 1;
            y = 0;
        }

        for (int i = 0; i < 9; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            square[x][y] = i + 1;
            magic(x, y + 1);
            selected[i] = false;
        }
    }

    private static boolean check() {

        int sum = square[0][0] + square[0][1] + square[0][2];

        for (int i = 1; i < 3; i++) {
            int s = 0;
            for (int j = 0; j < 3; j++) {
                s += square[i][j];
            }
            if (s != sum) return false;
        }

        for (int j = 0; j < 3; j++) {
            int s = 0;
            for (int i = 0; i < 3; i++) {
                s += square[i][j];
            }
            if (s != sum) return false;
        }

        if (square[0][0] + square[1][1] + square[2][2] != sum) return false;
        if (square[0][2] + square[1][1] + square[2][0] != sum) return false;

        return true;
    }

    private static int cost() {

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum += Math.abs(A[i][j] - square[i][j]);
            }
        }

        return sum;
    }
}
