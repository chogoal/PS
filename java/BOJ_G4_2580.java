import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_2580 {

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean sudoku(int x, int y) {

        if (y == 9) {
            if (x == 8) return true;
            x += 1;
            y = 0;
        }

        if (map[x][y] != 0) return sudoku(x, y + 1);

        for (int i = 1; i <= 9; i++) {
            if (check(x, y, i)) {
                map[x][y] = i;
                if (sudoku(x, y + 1)) return true;
                map[x][y] = 0;
            }
        }

        return false;
    }

    private static boolean check(int x, int y, int num) {

        // 가로 체크
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num) return false;
        }

        // 세로 체크
        for (int i = 0; i < 9; i++) {
            if (map[i][y] == num) return false;
        }

        // 3 * 3 체크
        x = x / 3 * 3;
        y = y / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[x + i][y + j] == num) return false;
            }
        }

        return true;
    }
}