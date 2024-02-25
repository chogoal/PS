import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BOJ_G4_11559 {

    static char[][] field = new char[12][6];
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                field[i][j] = line.charAt(j);
            }
        }

        while (true) {
            visited = new boolean[12][6];
            if (next()) answer++;
            else break;
        }

        System.out.println(answer);
    }

    private static boolean next() { // 연쇄

        boolean check = false;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (field[i][j] != '.' && !visited[i][j]) {
                    if (bfs(i, j, field[i][j])) check = true;
                }
            }
        }

        return check;
    }

    private static boolean bfs(int i, int j, char c) { // 상하좌우로 연결된 뿌요 찾기

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { i, j });
        visited[i][j] = true;

        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(new int[] { i, j });

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || visited[nx][ny]) continue;

                if (field[nx][ny] == c) {
                    queue.offer(new int[] { nx, ny });
                    list.add(new int[] { nx, ny });
                    visited[nx][ny] = true;
                }
            }
        }

        if (list.size() >= 4) {
            pang(list);
            return true;
        }

        return false;
    }

    private static void pang(ArrayList<int[]> list) { // 뿌요 터뜨리기 & 내려오기

        for (int[] puyo : list) {
            field[puyo[0]][puyo[1]] = '.';
        }

        for (int j = 0; j < 6; j++) {
            for (int i = 11; i >= 0; i--) {
                if (field[i][j] == '.')  {
                    int bincan = i;
                    int k = i;
                    while (k > 0 && field[k][j] == '.') {
                        k--;
                    }
                    field[bincan][j] = field[k][j];
                    field[k][j] = '.';
                }
            }
        }
    }
}
