import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_14891 {

    static int[][] gear = new int[4][8];
    static int[] start = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = s.charAt(j) - '0'; // N극: 0, S극: 1
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken()) - 1; // 회전시킨 톱니바퀴
            int dir = Integer.parseInt(st.nextToken()); // 회전방향 (1: 시계방향, -1: 반시계방향)

            turn(num, dir);
        }

        int score = 0;
        score += gear[0][start[0]] == 0 ? 0 : 1;
        score += gear[1][start[1]] == 0 ? 0 : 2;
        score += gear[2][start[2]] == 0 ? 0 : 4;
        score += gear[3][start[3]] == 0 ? 0 : 8;

        System.out.println(score);
    }

    private static void turn(int num, int dir) {

        int[] isTurn = new int[4];
        isTurn[num] = dir;

        // 왼쪽
        int left = num;
        while (left > 0) {
            if (gear[left][(start[left] + 6) % 8] == gear[left - 1][(start[left - 1] + 2) % 8]) break;
            isTurn[left - 1] = isTurn[left] == 1 ? -1 : 1;
            left--;
        }

        // 오른쪽
        int right = num;
        while (right < 3) {
            if (gear[right][(start[right] + 2) % 8] == gear[right + 1][(start[right + 1] + 6) % 8]) break;
            isTurn[right + 1] = isTurn[right] == 1 ? -1 : 1;
            right++;
        }

        for (int i = 0; i < 4; i++) {
            if (isTurn[i] == 1) clockwise(i);
            else if (isTurn[i] == -1) counterClockwise(i);
        }
    }

    private static void clockwise(int num) {
        start[num] = (start[num] + 7) % 8;
    }

    private static void counterClockwise(int num) {
        start[num] = (start[num] + 1) % 8;
    }
}
