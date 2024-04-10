import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CDT_루돌프의_반란 {

    static int N, M, P, C, D;
    static Santa[] santaList;
    static int[] rudolph;
    static int[][] map;
    static int m; // 현재 라운드

    static int[] dx = { -1, 0, 1, 0 }; // 상우하좌
    static int[] dy = { 0, 1, 0, -1 };

    static class Santa {
        int r;
        int c;
        int score; // 산타가 얻은 점수
        int state; // 마지막으로 충돌이 일어난 턴
        boolean isDead; // 탈락 여부

        public Santa(int r, int c) {
            this.r = r;
            this.c = c;
            score = 0;
            state = 0;
            isDead = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 게임판의 크기
        M = Integer.parseInt(st.nextToken()); // 게임 턴 수
        P = Integer.parseInt(st.nextToken()); // 산타 수
        C = Integer.parseInt(st.nextToken()); // 루돌프의 힘
        D = Integer.parseInt(st.nextToken()); // 산타의 힘

        santaList = new Santa[P + 1];
        rudolph = new int[2];
        map = new int[N][N]; // 0: 빈 칸, 1~P: 산타

        // 루돌프
        st = new StringTokenizer(br.readLine());
        rudolph[0] = Integer.parseInt(st.nextToken()) - 1;
        rudolph[1] = Integer.parseInt(st.nextToken()) - 1;

        // 산타
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = num;
            santaList[num] = new Santa(r, c);
        }

        // 게임 시작
        game();

        // 게임 종료 후 산타의 점수
        for (int p = 1; p <= P; p++) {
            sb.append(santaList[p].score).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void game() {

        for (int i = 1; i <= M; i++) {

//            // 현상태 프린트
//            for (int r = 0; r < N; r++) {
//                for (int c = 0; c < N; c++) {
//                    System.out.print(map[r][c] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("rudolph : " + rudolph[0] + " " + rudolph[1]);

            m++;
            moveRudolph();
            moveSanta();

            // 각 산타의 탈락 여부 확인
            int deadCnt = 0;
            for (int p = 1; p <= P; p++) {
                if (santaList[p].isDead) deadCnt++;
                else santaList[p].score += 1;
            }

            // 모든 산타가 탈락했을 경우 게임 종료
            if (deadCnt == P) {
                return;
            }
        }
    }

    private static void moveRudolph() {

        // 가장 가까운 산타 찾기
        int goal = findNearestSanta();
        int r = santaList[goal].r;
        int c = santaList[goal].c;

        // 산타와 가장 가까워지는 방향 찾기
        int moveX = 0;
        if (r < rudolph[0]) moveX = -1;
        else if (r > rudolph[0]) moveX = 1;

        int moveY = 0;
        if (c < rudolph[1]) moveY = -1;
        else if (c > rudolph[1]) moveY = 1;

        // 1칸 이동
        rudolph[0] += moveX;
        rudolph[1] += moveY;

        // 충돌 여부 확인
        int num = map[rudolph[0]][rudolph[1]];
        if (num != 0) crashRudolph(num, moveX, moveY);
    }

    private static void crashRudolph(int num, int moveX, int moveY) { // 루돌프가 움직여 일어난 충돌

        Santa s = santaList[num]; // 밀려난 산타
        s.score += C;
        s.state = m;

        // 루돌프가 움직인 방향으로 C칸 밀려남
        map[s.r][s.c] = 0; // 산타의 원래 위치
        int nx = s.r + moveX * C; // 산타의 현재 위치
        int ny = s.c + moveY * C; // 산타의 현재 위치

        while (true) {

            if (!inRange(nx, ny)) { // 게임판 벗어나면 탈락
                santaList[num].isDead = true;
                break;
            }

            if (map[nx][ny] != 0) { // 밀려난 곳에 산타가 있다면 또 밀기

                // 다음 산타 번호
                int next = map[nx][ny];

                // 현재 산타 밀기
                map[nx][ny] = num;
                santaList[num].r = nx; santaList[num].c = ny;

                // 현재 산타 갱신
                num = next;
                nx += moveX; ny += moveY;
            } else { // 밀려난 곳이 빈 칸이면 종료

                map[nx][ny] = num;
                santaList[num].r = nx; santaList[num].c = ny;

                break;
            }
        }
    }

    private static void moveSanta() {

        for (int i = 1; i <= P; i++) {

            // 탈락한 산타 제외
            if (santaList[i].isDead) continue;

            // 기절한 산타 제외
            if (santaList[i].state != 0) {
                if (santaList[i].state == m || santaList[i].state == m - 1) continue;
            }

            int r = santaList[i].r;
            int c = santaList[i].c;

            // 루돌프에게 가까워지는 방향으로 1칸 이동
            int min = distance(r, c, rudolph[0], rudolph[1]);
            int dir = 4;

            for (int d = 0; d < 4; d++) {
                int nx = r + dx[d];
                int ny = c + dy[d];

                // 이동할 수 있는 칸인지 확인
                if (!inRange(nx, ny) || map[nx][ny] != 0) continue;

                // 루돌프와의 거리 계산
                int dist = distance(nx, ny, rudolph[0], rudolph[1]);
                if (dist < min) {
                    min = dist;
                    dir = d;
                }
            }

            // 산타 이동
            if (dir != 4) {

                map[r][c] = 0;
                santaList[i].r += dx[dir];
                santaList[i].c += dy[dir];
                map[santaList[i].r][santaList[i].c] = i;

                // 충돌 여부 확인
                if (santaList[i].r == rudolph[0] && santaList[i].c == rudolph[1]) {
                    crashSanta(i, (dir + 2) % 4);
                }
            }
        }
    }

    private static void crashSanta(int num, int dir) { // 산타가 움직여 일어난 충돌

        Santa s = santaList[num];
        s.score += D;
        s.state = m;

        // dir 반대 방향으로 D칸 밀려남
        map[s.r][s.c] = 0;
        int nx = s.r + dx[dir] * D;
        int ny = s.c + dy[dir] * D;

        while (true) {

            if (!inRange(nx, ny)) { // 게임판 벗어나면 탈락
                santaList[num].isDead = true;
                break;
            }

            if (map[nx][ny] != 0) { // 밀려난 곳에 산타가 있다면 또 밀기

                // 다음 산타
                int next = map[nx][ny];

                // 현재 산타 밀기
                map[nx][ny] = num;
                santaList[num].r = nx; santaList[num].c = ny;

                // 현재 산타 갱신
                num = next;
                nx += dx[dir]; ny += dy[dir];
            } else {

                map[nx][ny] = num;
                santaList[num].r = nx; santaList[num].c = ny;

                break;
            }
        }
    }

    private static int findNearestSanta() {

        int goal = 0; // 목표 산타의 번호
        int min = Integer.MAX_VALUE; // 산타와의 거리

        for (int i = 1; i <= P; i++) {
            if (santaList[i].isDead) continue; // 탈락한 산타는 패스

            int dist = distance(santaList[i].r, santaList[i].c, rudolph[0], rudolph[1]);

            if (dist < min) { // 더 가까운 산타로 갱신
                goal = i;
                min = dist;
            } else if (dist == min) { // 거리가 같으면 r, c로 비교
                if (santaList[i].r > santaList[goal].r) goal = i;
                else if (santaList[i].r == santaList[goal].r) {
                    if (santaList[i].c > santaList[goal].c) goal = i;
                }
            }
        }

        return goal;
    }

    private static int distance(int x, int y, int a, int b) {
        return (int)Math.pow(x - a, 2) + (int)Math.pow(y - b, 2);
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
