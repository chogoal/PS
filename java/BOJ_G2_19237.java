import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G2_19237 {

    static int N, M, k;
    static Pos[][] map;
    static Shark[] sharks;
    static int[][][] priority;
    static int time;

    static int[] dx = { -1, 1, 0, 0 }; // 위, 아래, 왼쪽, 오른쪽
    static int[] dy = { 0, 0, -1, 1 };

    static class Shark {
        int x;
        int y;
        int dir;
        boolean isDead;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.dir = 0;
            this.isDead = false;
        }
    }

    static class Pos {
        int shark; // 냄새 있으면 상어 번호, 없으면 -1
        int time; // 냄새 뿌린 시간, 냄새 없으면 -1
        boolean before; // 덮어씌워지기 전에 남아있던 냄새 여부

        public Pos(int shark, int time) {
            this.shark = shark;
            this.time = time;
            this.before = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new Pos[N][N];
        sharks = new Shark[M];
        priority = new int[M][4][4];

        // 격자
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 0) { // 빈 칸
                    map[i][j] = new Pos(-1, -1);
                } else { // 상어 있는 칸
                    map[i][j] = new Pos(num - 1, 0);
                    sharks[num - 1] = new Shark(i, j);
                }
            }
        }

        // 각 상어의 방향
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sharks[i].dir = Integer.parseInt(st.nextToken()) - 1;
        }

        // 각 상어의 방향 우선순위
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    priority[i][j][k] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }

        move();

        System.out.println(time);
    }

    private static void move() {

        while (true) {

            if (time > 1000) {
                time = -1; break;
            }

            boolean allDead = true;
            for (int i = 1; i < M; i++) {
                if (!sharks[i].isDead) { allDead = false; break; }
            }

            // 1번 상어를 제외한 나머지가 모두 죽었다면 종료
            if (allDead) break;

            time++;

            for (int i = 0; i < M; i++) {
                Shark shark = sharks[i];

                // 없어진 상어라면 패스
                if (sharks[i].isDead) continue;

                // 인접한 빈 칸으로 이동
                boolean canMove = false;
                for (int d = 0; d < 4; d++) {
                    int nd = priority[i][shark.dir][d];
                    int nx = shark.x + dx[nd];
                    int ny = shark.y + dy[nd];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    Pos p = map[nx][ny];

                    // 덮어씌워지기 전에 빈 칸이었다면,
                    if (p.time == time && !p.before) {
                        sharks[i].isDead = true;
                        canMove = true;
                        break;
                    }

                    // 다음 칸이 빈 칸이거나, 냄새가 사라졌다면
                    if (p.time == -1 || p.time + k < time) {

                        // 해당 칸으로 상어 이동
                        canMove = true;
                        sharks[i].x = nx;
                        sharks[i].y = ny;
                        sharks[i].dir = nd;

                        // 냄새 뿌리기
                        map[nx][ny].shark = i;
                        map[nx][ny].time = time;
                        map[nx][ny].before = false;
                        break;
                    }
                }

                // 빈 칸이 없다면, 자신의 냄새가 있는 칸으로 이동
                if (!canMove) {
                    for (int d = 0; d < 4; d++) {
                        int nd = priority[i][shark.dir][d];
                        int nx = shark.x + dx[nd];
                        int ny = shark.y + dy[nd];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                        if (map[nx][ny].shark == i) {
                            sharks[i].x = nx;
                            sharks[i].y = ny;
                            sharks[i].dir = nd;
                            map[nx][ny].time = time;
                            map[nx][ny].before = true;
                            break;
                        }
                    }
                }
            }

            print();
        }
    }

    private static void print() {

        System.out.println("----MAP----");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].shark == -1) {
                    System.out.print("0(" + map[i][j].time + ")\t");
                } else {
                    System.out.print(map[i][j].shark + 1 + "(" + map[i][j].time + ")\t");
                }
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("----SHARK----");
        for (int i = 0; i < M; i++) {
            System.out.println(sharks[i].x + " " + sharks[i].y + " " + sharks[i].dir + " " + sharks[i].isDead);
        }
        System.out.println();
    }
}
