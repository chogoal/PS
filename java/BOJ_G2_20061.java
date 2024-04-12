import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G2_20061 {

    static final int H = 10;
    static final int W = 4;
    static int[][] green_board = new int[H][W];
    static int[][] blue_board = new int[H][W];
    static boolean line1, line2; // 연한 칸의 블록 여부 확인
    static int score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            put_green_block(t, x, y);

            if (t == 2) t = 3;
            else if (t == 3) t = 2;
            put_blue_block(t, y, x);
        }

        int cnt = 0;
        for (int i = 6; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (blue_board[i][j] == 1) cnt++;
                if (green_board[i][j] == 1) cnt++;
            }
        }

        sb.append(score).append("\n").append(cnt);
        System.out.println(sb.toString());
    }

    private static void put_green_block(int t, int x, int y) {

        // 1 x 1 블록
        if (t == 1) {

            // 바닥에 닿거나 타일을 만날 때까지 아래로 내려오기
            while (x < H && green_board[x][y] != 1) {
                x++;
            }
            green_board[x - 1][y] = 1;

            // 꽉 찬 행 확인
            checkFull(0);

            // 연한 칸에 블록이 있는지 확인
            checkLine(0);
        }
        // 1 x 2 블록
        else if (t == 2) {

            int y2 = y + 1;
            while (x < H && green_board[x][y] != 1 && green_board[x][y2] != 1) {
                x++;
            }
            green_board[x - 1][y] = 1;
            green_board[x - 1][y2] = 1;

            checkFull(0);
            checkLine(0);
        }
        // 2 x 1 블록
        else {

            x += 1;
            while (x < H && green_board[x][y] != 1) {
                x++;
            }
            green_board[x - 2][y] = 1;
            green_board[x - 1][y] = 1;

            checkFull(0);
            checkLine(0);
        }
    }

    private static void put_blue_block(int t, int x, int y) {

        // 1 x 1 블록
        if (t == 1) {

            // 바닥에 닿거나 타일을 만날 때까지 아래로 내려오기
            while (x < H && blue_board[x][y] != 1) {
                x++;
            }
            blue_board[x - 1][y] = 1;

            // 꽉 찬 행 확인
            checkFull(1);

            // 연한 칸에 블록이 있는지 확인
            checkLine(1);
        }
        // 1 x 2 블록
        else if (t == 2) {

            int y2 = y + 1;
            while (x < H && blue_board[x][y] != 1 && blue_board[x][y2] != 1) {
                x++;
            }
            blue_board[x - 1][y] = 1;
            blue_board[x - 1][y2] = 1;

            checkFull(1);
            checkLine(1);
        }
        // 2 x 1 블록
        else {

            x += 1;
            while (x < H && blue_board[x][y] != 1) {
                x++;
            }
            blue_board[x - 2][y] = 1;
            blue_board[x - 1][y] = 1;

            checkFull(1);
            checkLine(1);
        }
    }

    private static void checkFull(int color) {

        // 그린
        if (color == 0) {
            for (int i = 6; i < H; i++) {

                boolean full = true;
                for (int j = 0; j < W; j++) {
                    if (green_board[i][j] == 0) {
                        full = false;
                        break;
                    }
                }

                // 행이 블록으로 채워졌다면
                if (full) {
                    score++;

                    // 한 칸 씩 아래로 내려오기
                    for (int k = i; k >= 4; k--) {
                        for (int j = 0; j < W; j++) {
                            green_board[k][j] = green_board[k - 1][j];
                        }
                    }
                }
            }
        }
        // 블루 (동일 로직 반복)
        else if (color == 1) {
            for (int i = 6; i < H; i++) {
                boolean full = true;
                for (int j = 0; j < W; j++) {
                    if (blue_board[i][j] == 0) {
                        full = false;
                        break;
                    }
                }

                if (full) {
                    score++;

                    for (int k = i; k >= 4; k--) {
                        for (int j = 0; j < W; j++) {
                            blue_board[k][j] = blue_board[k - 1][j];
                        }
                    }
                }
            }
        }
    }

    private static void checkLine(int color) {

        // 변수 초기화
        line1 = false; line2 = false;

        // 그린
        if (color == 0) {

            // 블록 여부 확인
            for (int i = 0; i < W; i++) {
                if (green_board[4][i] == 1) { line1 = true; line2 = true; break; }
            }

            for (int i = 0; i < W; i++) {
                if (green_board[5][i] == 1) { line2 = true; break; }
            }

            // 연한 칸 둘 다 블록 존재
            if (line1 && line2) {
                for (int i = H - 1; i >= 4; i--) {
                    for (int j = 0; j < W; j++) {
                        green_board[i][j] = green_board[i - 2][j];
                    }
                }
            }
            // 연한 칸 아랫줄만 블록 존재
            else if (line2) {
                for (int i = H - 1; i >= 5; i--) {
                    for (int j = 0; j < W; j++) {
                        green_board[i][j] = green_board[i - 1][j];
                    }
                }
            }
        }

        // 블루
        else if (color == 1) {

            // 블록 여부 확인
            for (int i = 0; i < W; i++) {
                if (blue_board[4][i] == 1) { line1 = true; line2 = true; break; }
            }

            for (int i = 0; i < W; i++) {
                if (blue_board[5][i] == 1) { line2 = true; break; }
            }

            // 연한 칸 둘 다 블록 존재
            if (line1 && line2) {
                for (int i = H - 1; i >= 4; i--) {
                    for (int j = 0; j < W; j++) {
                        blue_board[i][j] = blue_board[i - 2][j];
                    }
                }
            }
            // 연한 칸 아랫줄만 블록 존재
            else if (line2) {
                for (int i = H - 1; i >= 5; i--) {
                    for (int j = 0; j < W; j++) {
                        blue_board[i][j] = blue_board[i - 1][j];
                    }
                }
            }
        }
    }
}
