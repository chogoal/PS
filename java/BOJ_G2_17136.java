import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G2_17136 {

    static int[][] paper = new int[10][10];
    static int[] count = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            count[i] = 5;
        }

        for (int i = 5; i >= 1; i--) {
            cover(i);
        }

        print();

        if (!check()) {
            System.out.println(-1);
        } else {
            int sum = 25;
            for (int remain : count) sum -= remain;
            System.out.println(sum);
        }
    }

    private static void print() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(paper[i][j]);
            }
            System.out.println();
        }
    }

    private static void cover(int size) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                boolean check = true;
                ex:
                for (int r = 0; r < size; r++) {
                    for (int c = 0; c < size; c++) {
                        if (i + r >= 10 || j + c >= 10 || paper[i + r][j + c] != 1) {
                            check = false;
                            break ex;
                        }
                    }
                }

                if (check) {
                    count[size - 1]--;
                    for (int r = 0; r < size; r++) {
                        for (int c = 0; c < size; c++) {
                            paper[i + r][j + c] = 2;
                        }
                    }
                    i += size;
                    j += size;
                }

                if (count[size - 1] == 0) return;
            }
        }
    }

    private static boolean check() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (paper[i][j] == 1) return false;
            }
        }

        return true;
    }
}
