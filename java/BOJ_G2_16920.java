import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G2_16920 {

    static int N, M, P;
    static char[][] map;
    static int[] dist; // 플레이어 별 확장 범위
    static int[] castle; // 플레이어 별 성의 개수
    static Queue<int[]>[] queueList;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dist = new int[P];
        castle = new int[P];

        // 큐 초기화
        queueList = new ArrayDeque[P];
        for (int i = 0; i < P; i++) {
            queueList[i] = new ArrayDeque<int[]>();
        }

        // 최대 확장 범위, 범위가 맵보다 크면, 맵의 최대 길이로 수정
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
            dist[i] = Math.min(dist[i], Math.max(M, N));
        }

        // 입력 받으면서 현재 성의 위치는 큐에, 성의 개수는 castle에 저장
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] - '0' >= 1 && map[i][j] - '0' <= P) {
                    int player = map[i][j] - '0' - 1;
                    queueList[player].offer(new int[] { i, j });
                    castle[player]++;
                }
            }
        }

        // 각 플레이어 별로 bfs 수행, 모든 플레이어의 bfs 수행 전과 후의 성 개수가 같으면 종료
        while (true) {
            int count = 0;
            for (int i = 0; i < P; i++) {
                count += bfs(i);
            }
            if (count == 0) break;
        }

        for (int c : castle) {
            sb.append(c).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int bfs(int player) {

        Queue<int[]> queue = queueList[player];
        int count = 0;

        for (int i = 0; i < dist[player]; i++) {
            int size = queue.size();
            while (size-- > 0) {
                int[] top = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = top[0] + dx[d];
                    int ny = top[1] + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != '.') continue;

                    queue.offer(new int[]{ nx, ny });
                    map[nx][ny] = (char) ((player + 1) + '0');
                    castle[player]++;
                    count++;
                }
            }
        }

        return count;
    }
}
