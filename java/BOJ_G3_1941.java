import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_G3_1941 {

    static int count;
    static char[][] seat = new char[5][5];
    static boolean[] visited = new boolean[25];
    static int[] selected = new int[7]; // 선택된 7개의 자리

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                seat[i][j] = s.charAt(j);
            }
        }

        comb(0, 0, 0);

        System.out.println(count);
    }

    private static void comb(int cnt, int y, int start) {

        if (y >= 4) return;

        if (cnt == 7) {
            if (bfs()) { // 7개의 자리가 선택되면, 서로 연결된 자리인지 확인
                count++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[cnt] = i;

                if (seat[i / 5][i % 5] == 'Y') {
                    comb(cnt + 1, y + 1, i + 1);
                } else {
                    comb(cnt + 1, y, i + 1);
                }

                visited[i] = false;
            }
        }
    }

    private static boolean bfs() {

        int check = 0;

        boolean[] bfsVisited = new boolean[25];

        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(selected[0]);
        bfsVisited[selected[0]] = true;
        check++;

        while (!queue.isEmpty()) {
            int top = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = top / 5 + dx[d];
                int ny = top % 5 + dy[d];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;

                if (bfsVisited[nx * 5 + ny]) continue;

                if (!visited[nx * 5 + ny]) continue;

                queue.offer(nx * 5 + ny);
                bfsVisited[nx * 5 + ny] = true;
                check++;
            }
        }

        return check == 7;
    }
}
