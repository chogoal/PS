import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G4_20056 {

    static int N, M, K;
    static List<FireBall>[][] map;
    static List<FireBall> ballList;
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static class FireBall {
        int r;
        int c;
        int m; // 질량
        int s; // 속력
        int d; // 방향

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (M == 0) { System.out.println(0); return; }

        map = new ArrayList[N][N];
        ballList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<FireBall>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r][c].add(new FireBall(r, c, m, s, d));
            ballList.add(new FireBall(r, c, m, s, d));
        }

        for (int k = 0; k < K; k++) {

            move();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].size() >= 2) {
                        divide(i, j, map[i][j]);
                    }
                }
            }

            init();
        }

        int sum = 0;
        for (FireBall f : ballList) {
            sum += f.m;
        }

        System.out.println(sum);
    }

    private static void init() {

        ballList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() > 0) {
                    for (FireBall f : map[i][j]) {
                        ballList.add(f);
                    }
                }
            }
        }
    }

    private static void move() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        // 모든 파이어볼이 d 방향으로 s 속력만큼 이동
        for (FireBall f : ballList) {
            int nr = f.r + dx[f.d] * f.s % N;
            int nc = f.c + dy[f.d] * f.s % N;

            if (nr >= N) nr -= N;
            if (nr < 0) nr += N;
            if (nc >= N) nc -= N;
            if (nc < 0) nc += N;

            f.r = nr;
            f.c = nc;
            map[f.r][f.c].add(f);
        }
    }

    private static void divide(int i, int j, List<FireBall> list) {

        int cnt = list.size();
        int mSum = 0; // 질량의 합
        int sSum = 0; // 속력의 합
        int oddCnt = 0; int evenCnt = 0;

        for (FireBall f : list) {
            mSum += f.m;
            sSum += f.s;
            if (f.d % 2 == 0) evenCnt++;
            else oddCnt++;
        }

        map[i][j] = new ArrayList<FireBall>();
        int newM = mSum / 5;
        int newS = sSum / cnt;
        int[] newD = (oddCnt == cnt || evenCnt == cnt) ? new int[]{ 0, 2, 4, 6 } : new int[]{ 1, 3, 5, 7 };
        if (newM > 0) {
            for (int d = 0; d < 4; d++) {
                map[i][j].add(new FireBall(i, j, newM, newS, newD[d]));
            }
        }
    }
}
