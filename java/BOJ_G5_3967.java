import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_3967 {

    static int[] nums;
    static char[][] star;
    static boolean[] selected;
    static int[][] check = {{ 0, 2, 5, 7 }, { 7, 8, 9, 10 }, { 0, 3, 6, 10 },
                            { 1, 2, 3, 4 }, { 1, 5, 8, 11 }, { 4, 6, 9, 11 }};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        nums = new int[12];
        star = new char[5][9];
        selected = new boolean[12];

        int idx = 0;
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                char c = line.charAt(j);

                star[i][j] = c;
                if (c == '.') continue;
                if (c == 'x') nums[idx++] = 0;
                else {
                    nums[idx++] = c - 'A' + 1;
                    selected[c - 'A'] = true;
                }
            }
        }

        perm(0);

        idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (star[i][j] == '.') sb.append(star[i][j]);
                else sb.append((char) (nums[idx++] + 'A' - 1));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean perm(int cnt) {

        if (cnt == 12) return check();

        if (nums[cnt] != 0) return perm(cnt + 1);

        for (int i = 1; i <= 12; i++) {
            if (selected[i - 1]) continue;
            selected[i - 1] = true;
            nums[cnt] = i;
            if (perm(cnt + 1)) return true;
            nums[cnt] = 0;
            selected[i - 1] = false;
        }

        return false;
    }

    private static boolean check() {

        for (int i = 0; i < 6; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += nums[check[i][j]];
            }
            if (sum != 26) return false;
        }

        return true;
    }
}
