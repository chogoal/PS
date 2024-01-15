import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_2630 {

    static int white = 0;
    static int blue = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(N, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void check(int n, int startX, int startY) {

        int prev = paper[startX][startY];
ex:     for (int i = startX; i < startX + n; i++) {
            for (int j = startY; j < startY + n; j++) {
                if (paper[i][j] != prev) {
                    prev = -1;
                    break ex;
                }
            }
        }

        if (prev == 0) white++;
        else if (prev == 1) blue++;
        else {
            int nextN = n / 2;
            check(nextN, startX, startY);
            check(nextN, startX, startY + nextN);
            check(nextN, startX + nextN, startY);
            check(nextN, startX + nextN, startY + nextN);
        }

    }
}