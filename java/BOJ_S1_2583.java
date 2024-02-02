import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_S1_2583 {

    static int M, N, K;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        paper = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int r = y1; r < y2; r++) {
                for (int c = x1; c < x2; c++) {
                    paper[r][c] = 1;
                }
            }
        }

        int count = 0;
        List<Integer> areaList = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (paper[i][j] == 0) {
                    areaList.add(bfs(i, j));
                    count++;
                }
            }
        }

        Collections.sort(areaList);

        sb.append(count).append("\n");
        for (int i = 0; i < areaList.size(); i++) {
            sb.append(areaList.get(i)).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int bfs(int i, int j) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { i, j });
        paper[i][j] = -1; // 방문처리

        int area = 1;

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };

        while (!queue.isEmpty()) {
            int[] top = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = top[0] + dx[d];
                int ny = top[1] + dy[d];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && paper[nx][ny] == 0) {
                    queue.offer(new int[] { nx, ny });
                    paper[nx][ny] = -1;
                    area++;
                }
            }
        }

        return area;
    }
}
