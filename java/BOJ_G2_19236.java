import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G2_19236 {

    static int[][] area = new int[4][4];
    static Fish[] fishes = new Fish[17];
    static Shark shark;
    static int max;

    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

    static class Fish {
        int x;
        int y;
        int dir;
        boolean isDead;

        public Fish(int x, int y, int dir, boolean isDead) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.isDead = isDead;
        }
    }

    static class Shark {
        int x;
        int y;
        int dir;
        int eatSum;

        public Shark(int x, int y, int dir, int eatSum) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.eatSum = eatSum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken()); // num
                int b = Integer.parseInt(st.nextToken()) - 1; // dir
                area[i][j] = a;
                fishes[a] = new Fish(i, j, b, false);
            }
        }

        // (0, 0)에서 상어 시작
        int fishNum = area[0][0]; // (0, 0)에 있던 물고기 번호
        shark = new Shark(0, 0, fishes[fishNum].dir, fishNum);
        area[0][0] = -1;
        fishes[fishNum].isDead = true;

        dfs();

        System.out.println(max);
    }

    private static void dfs() {

        // 상어가 먹은 물고기 번호 합의 최대
        max = Math.max(max, shark.eatSum);

        // 물고기 이동
        fishMove();

        // 상어 이동
        for (int d = 1; d <= 3; d++) {
            int nx = shark.x + dx[shark.dir] * d;
            int ny = shark.y + dy[shark.dir] * d;

            // 범위 벗어나면 종료
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;

            // 물고기가 없는 칸이면, 다음 칸 탐색
            if (area[nx][ny] == 0) continue;

            // 원복을 위한 복제
            Shark originShark = new Shark(shark.x, shark.y, shark.dir, shark.eatSum);

            int[][] originArea = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    originArea[i][j] = area[i][j];
                }
            }

            Fish[] originFish = new Fish[17];
            for (int i = 1; i <= 16; i++) {
                originFish[i] = new Fish(fishes[i].x, fishes[i].y, fishes[i].dir, fishes[i].isDead);
            }

            // 상어 이동
            int fishNum = area[nx][ny]; // 이동할 칸의 물고기 번호
            area[shark.x][shark.y] = 0;
            shark.x = nx; shark.y = ny;
            shark.dir = fishes[fishNum].dir; shark.eatSum += fishNum; // 물고기 먹기
            area[nx][ny] = -1;
            fishes[fishNum].isDead = true;

            dfs();

            // 복원
            shark = originShark;
            area = originArea;
            fishes = originFish;
        }
    }

    private static void fishMove() {

        for (int i = 1; i <= 16; i++) {

            // 번호 순서대로 이동
            Fish fish = fishes[i];

            // 죽은 물고기라면 패스
            if (fish.isDead) continue;

            for (int d = 0; d < 8; d++) {
                int nd = (fish.dir + d) % 8;
                int nx = fish.x + dx[nd];
                int ny = fish.y + dy[nd];
                if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || area[nx][ny] == -1) continue;

                int fishNum = area[nx][ny]; // 이동할 칸에 있는 물고기 번호

                // 이동할 칸에 물고기가 있다면, 해당 물고기를 현재 칸으로 이동
                if (fishNum != 0) {
                    fishes[fishNum].x = fish.x;
                    fishes[fishNum].y = fish.y;
                    area[fish.x][fish.y] = fishNum;
                } else { // 이동할 칸에 물고기가 없다면, 현재 칸으로 0으로 변경
                    area[fish.x][fish.y] = 0;
                }

                // 이동할 칸으로 현재 물고기 이동
                fishes[i].x = nx; fishes[i].y = ny; fishes[i].dir = nd;
                area[nx][ny] = i;
                break;
            }
        }
    }
}
