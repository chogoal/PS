import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_G2_12100 {

    static int N;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move(0, board);

        System.out.println(max);
    }

    private static void move(int cnt, int[][] board) {

        if (cnt == 5) {
            findMax(board);
            return;
        }

        int[][] boardCopy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boardCopy[i][j] = board[i][j];
            }
        }

        // 위
        int[][] movedUp = up(boardCopy);
        move(cnt + 1, movedUp);

        // 아래
        int[][] movedDown = down(boardCopy);
        move(cnt + 1, movedDown);

        // 왼
        int[][] movedLeft = left(boardCopy);
        move(cnt + 1, movedLeft);

        // 오른
        int[][] movedRight = right(boardCopy);
        move(cnt + 1, movedRight);

    }

    private static void findMax(int[][] board) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
    }

    private static int[][] up(int[][] board) {

        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[][] moved = new int[N][N];

        for (int j = 0; j < N; j++) {

            int top = 0;
            for (int i = 0; i < N; i++) {
                if (board[i][j] == 0) continue;

                if (deque.isEmpty()) {
                    deque.offer(board[i][j]);
                    top = board[i][j];
                    continue;
                }

                if (board[i][j] == top) {
                    deque.offerLast(deque.pollLast() * 2);
                    top = 0;
                } else {
                    deque.offerLast(board[i][j]);
                    top = board[i][j];
                }
            }

            int index = 0;
            while (!deque.isEmpty()) {
                moved[index++][j] = deque.pollFirst();
            }
        }

        return moved;
    }

    private static int[][] down(int[][] board) {

        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[][] moved = new int[N][N];

        for (int j = 0; j < N; j++) {

            int top = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (board[i][j] == 0) continue;

                if (deque.isEmpty()) {
                    deque.offer(board[i][j]);
                    top = board[i][j];
                    continue;
                }

                if (board[i][j] == top) {
                    deque.offerLast(deque.pollLast() * 2);
                    top = 0;
                } else {
                    deque.offerLast(board[i][j]);
                    top = board[i][j];
                }
            }

            int index = N - 1;
            while (!deque.isEmpty()) {
                moved[index--][j] = deque.pollFirst();
            }
        }

        return moved;
    }

    private static int[][] left(int[][] board) {

        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[][] moved = new int[N][N];

        for (int i = 0; i < N; i++) {

            int top = 0;
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) continue;

                if (deque.isEmpty()) {
                    deque.offer(board[i][j]);
                    top = board[i][j];
                    continue;
                }

                if (board[i][j] == top) {
                    deque.offerLast(deque.pollLast() * 2);
                    top = 0;
                } else {
                    deque.offerLast(board[i][j]);
                    top = board[i][j];
                }
            }

            int index = 0;
            while (!deque.isEmpty()) {
                moved[i][index++] = deque.pollFirst();
            }
        }

        return moved;
    }

    private static int[][] right(int[][] board) {

        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[][] moved = new int[N][N];

        for (int i = 0; i < N; i++) {

            int top = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (board[i][j] == 0) continue;

                if (deque.isEmpty()) {
                    deque.offer(board[i][j]);
                    top = board[i][j];
                    continue;
                }

                if (board[i][j] == top) {
                    deque.offerLast(deque.pollLast() * 2);
                    top = 0;
                } else {
                    deque.offerLast(board[i][j]);
                    top = board[i][j];
                }
            }

            int index = N - 1;
            while (!deque.isEmpty()) {
                moved[i][index--] = deque.pollFirst();
            }
        }

        return moved;
    }
}
