import java.io.*;
import java.util.*;

public class BOJ_G5_20055 {

    static int N, K, M;
    static int[] belt;
    static Queue<Integer> queue;
    static int time, up, down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = 2 * N;

        belt = new int[M];
        queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            time++;
            up = (M - (time % M)) % M;
            down = (up + (N - 1)) % M;

            moveRobot();

            int cnt = 0;
            for (int b : belt) if (b == 0) cnt++;
            if (cnt >= K) break;
        }

        System.out.println(time);
    }

    private static void moveRobot() {

        // 로봇 이동
        int before = -1; // 직전에 이동한 로봇 위치
        int size = queue.size();

        while (size-- > 0) {
            int cur = queue.poll();
            if (cur == down) continue; // 내리는 위치에 있던 로봇

            int next = (cur + 1) % M;
            if (next == before) next = cur;
            else if (belt[next] == 0) next = cur;

            before = next;
            if (next != cur) belt[next]--;
            if (next != down) queue.offer(next);
        }

        // 로봇 올리기
        if (belt[up] != 0) {
            queue.offer(up);
            belt[up]--;
        }
    }
}
