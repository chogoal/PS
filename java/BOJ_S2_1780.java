import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_1780 {

    static int N;
    static int[][] paper;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        count = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, N);

        for (int c : count) {
            sb.append(c).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void recur(int i, int j, int size) {

        int first = paper[i][j];

        if (size == 1) {
            count[first + 1]++;
            return;
        }

        boolean check = false;
ex:     for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (paper[i + r][j + c] != first) {
                    check = true;
                    break ex;
                }
            }
        }

        if (check) {
            int newSize = size / 3;

            recur(i, j, newSize);
            recur(i, j + newSize, newSize);
            recur(i, j + (newSize * 2), newSize);

            recur(i + newSize, j, newSize);
            recur(i + newSize, j + newSize, newSize);
            recur(i + newSize, j + (newSize * 2), newSize);

            recur(i + (newSize * 2), j, newSize);
            recur(i + (newSize * 2), j + newSize, newSize);
            recur(i + (newSize * 2), j + (newSize * 2), newSize);
        } else {
            count[first + 1]++;
        }
    }
}
