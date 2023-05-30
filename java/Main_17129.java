import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_17129 { // 17129. 윌리암슨수액빨이딱따구리가 정보섬에 올라온 이유
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<int[]>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j) - '0';
                if (arr[i][j] == 2) { // 시작점이면 큐에 넣기
                    queue.offer(new int[]{i, j, 0}); // x, y, 거리
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] != 1) {
                    if (arr[nx][ny] > 2) { // 음식이면 종료
                        sb.append("TAK").append("\n").append(cur[2] + 1);
                        System.out.println(sb.toString());
                        return;
                    } else { // 뚫린 길이면 큐에 넣기
                        queue.offer(new int[]{nx, ny, cur[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        sb.append("NIE");
        System.out.println(sb.toString());
    }

}