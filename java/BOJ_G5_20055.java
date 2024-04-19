import java.io.*;
import java.util.*;

public class BOJ_G5_20055 {

    static int N, K, M;
    static int[] belt;
    static boolean[] robot;
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = 2 * N;

        belt = new int[M];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            time++;

            moveBelt();
            moveRobot();

            int cnt = 0;
            for (int b : belt) if (b == 0) cnt++;
            if (cnt >= K) break;
        }

        System.out.println(time);
    }

    private static void moveBelt() {

        // 컨베이어 벨트 이동
        int temp = belt[M - 1];
        for (int i = M - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = temp;

        // 로봇 이동
        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[N - 1] = false; // 내리는 위치
    }

    private static void moveRobot() {

        // 로봇 한 칸 이동
        for (int i = N - 2; i >= 0; i--) {
            if (!robot[i]) continue;

            int next = i + 1; // 로봇이 이동하는 다음 칸

            if (robot[next]) next = i; // 다음 칸에 로봇 있으면 이동x
            else if (belt[next] == 0) next = i; // 다음 칸의 내구도가 0이면 이동x

            // 다음 칸으로 이동할 수 있다면 이동o
            if (next != i) {
                robot[i] = false;
                robot[next] = true;
                belt[next]--;
            }

            // 다음 칸이 내리는 위치라면 로봇 없애기
            if (next == N - 1) robot[next] = false;
        }

        // 로봇 올리기
        if (belt[0] != 0) {
            robot[0] = true;
            belt[0]--;
        }
    }
}
