import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G2_11967 {

    static int N, M;
    static int count; // 불이 켜진 방 개수
    static ArrayList<Pos>[][] light;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        light = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                light[i][j] = new ArrayList<Pos>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            light[x][y].add(new Pos(a, b));
        }

        bfs();

        System.out.println(count);
    }

    private static void bfs() {

        boolean[][] visited = new boolean[N][N]; // 방문체크
        boolean[][] lightOn = new boolean[N][N]; // 불이 켜져있는지 체크
        boolean[][] moveTo = new boolean[N][N]; // 이동 가능한지 체크

        Queue<Pos> queue = new ArrayDeque<Pos>();
        queue.offer(new Pos(0, 0));
        visited[0][0] = true; // 방문 체크
        lightOn[0][0] = true; // 불 켜짐
        moveTo[0][0] = true; // 이동 가능
        count++;

        while (!queue.isEmpty()) {

            Pos now = queue.poll();

            // 현재 방에서 이동할 수 있는 방 전부 체크
            for (int d = 0; d < 4; d++) {
                int nx = now.i + dx[d];
                int ny = now.j + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                moveTo[nx][ny] = true;
            }

            // 현재 방의 스위치 모두 켜기
            ArrayList<Pos> list = light[now.i][now.j];
            for (Pos p : list) {
                if (!lightOn[p.i][p.j]) {
                    lightOn[p.i][p.j] = true; // 불 켜기
                    count++;
                    if (moveTo[p.i][p.j] && !visited[p.i][p.j]) {
                        queue.offer(new Pos(p.i, p.j));
                    }
                }
            }

            // 다음 방으로 이동
            for (int d = 0; d < 4; d++) {
                int nx = now.i + dx[d];
                int ny = now.j + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                // 불이 꺼져 있거나, 이동할 수 없거나, 방문했던 곳이면 이동 불가
                if (!lightOn[nx][ny] || !moveTo[nx][ny] || visited[nx][ny]) continue;

                queue.offer(new Pos(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}
