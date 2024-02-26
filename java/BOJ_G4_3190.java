import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_G4_3190 {

    static int N;
    static int[][] board;

    static int dir;
    static char[] direction = new char[10001];
    static Deque<int[]> snake = new ArrayDeque<int[]>();

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 2; // 사과
        }

        int L = Integer.parseInt(br.readLine());
        for (int l = 0; l < L; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            direction[X] = C;
        }

        // 뱀은 (0, 0)에서 시작, 오른쪽으로 이동
        snake.offer(new int[] { 0, 0 });
        board[0][0] = 1;
        dir = 0;

        System.out.println(dummy());
    }

    private static int dummy() {

        int time = 0;

        while (true) {

            time++;

            // 다음 칸 계산
            int nx = snake.peekFirst()[0] + dx[dir];
            int ny = snake.peekFirst()[1] + dy[dir];

            // 다음 칸이 벽이거나 뱀의 몸이면 게임 종료
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1) break;

            // 사과 유무 확인
            boolean isApple = board[nx][ny] == 2;

            // 머리를 다음 칸에 위치시키기
            snake.offerFirst(new int[] { nx, ny });
            board[nx][ny] = 1;

            // 다음 칸에 사과가 없다면, 꼬리가 위치한 칸 비워주기
            if (!isApple) {
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }

            // 다음 이동방향 설정
            if (direction[time] == 'L') dir = (dir + 3) % 4;
            else if (direction[time] == 'D') dir = (dir + 1) % 4;
        }

        return time;
    }
}
