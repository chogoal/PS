import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G1_9328 {

    static int h, w;
    static char[][] building;
    static boolean[] key;
    static ArrayList<int[]>[] door;

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            // 빌딩 초기화, 외곽을 . 으로 채우기
            building = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(building[i], '.');
            }

            // 문 리스트 초기화
            door = new ArrayList['Z' - 'A' + 1];
            for (int i = 0; i < door.length; i++) {
                door[i] = new ArrayList<int[]>();
            }

            // 빌딩, 문 리스트에 각 알파벳 별 문의 위치 추가
            for (int i = 1; i < h + 1; i++) {
                String s = br.readLine();
                for (int j = 1; j < w + 1; j++) {
                    building[i][j] = s.charAt(j - 1);
                    if (isDoor(building[i][j])) {
                        door[building[i][j] - 'A'].add(new int[] { i, j });
                    }
                }
            }

            // 상근이가 가지고 있는 열쇠 목록
            String keys = br.readLine();
            key = new boolean['z' - 'a' + 1];
            for (int i = 0; i < keys.length(); i++) {
                if (keys.charAt(i) == '0') break;
                key[keys.charAt(i) - 'a'] = true;
            }

            sb.append(find()).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int find() {

        int docs = 0;

        boolean[][] moveTo = new boolean[h + 2][w + 2];
        boolean[][] visited = new boolean[h + 2][w + 2];

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { 0, 0 });
        visited[0][0] = true;
        moveTo[0][0] = true;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2) continue;

                if (visited[nx][ny] || building[nx][ny] == '*') continue;

                moveTo[nx][ny] = true; // 방문하지 않았고, 벽이 아니라면 이동 가능한 경로로 체크

                char c = building[nx][ny];

                if (c == '$') { // 문서
                    docs++;
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                } else if (c == '.') { // 빈 공간
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                } else if (isDoor(c) && key[c - 'A']) { // 열쇠가 있는 문
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                } else if (isKey(c)) { // 열쇠
                    if (!key[c - 'a']) { // 가지고 있지 않던 열쇠
                        key[c - 'a'] = true;
                        for (int[] dd : door[c - 'a']) {
                            if (moveTo[dd[0]][dd[1]]) {
                                queue.offer(new int[] { dd[0], dd[1] });
                                visited[dd[0]][dd[1]] = true;
                            }
                        }
                    }
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                }
            }
        }

        return docs;
    }

    private static boolean isKey(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static boolean isDoor(char c) {
        return c >= 'A' && c <= 'Z';
    }

}
