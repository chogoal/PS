import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G5_15686 {

    static int N, M;
    static int[][] map;
    static int[] selected;
    static List<int[]> house, store;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        selected = new int[M];
        house = new ArrayList<>();
        store = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) house.add(new int[] { i, j });
                else if (map[i][j] == 2) store.add(new int[] { i, j });
            }
        }

        comb(0, 0);

        System.out.println(min);
    }

    private static void comb(int cnt, int idx) {

        if (cnt == M) {
            min = Math.min(min, distance());
            return;
        }

        for (int i = idx; i < store.size(); i++) {
            selected[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    private static int distance() {

        int sum = 0; // 도시의 치킨 거리

        // 각각의 집에서 가장 가까운 치킨집 찾기
        for (int i = 0; i < house.size(); i++) {
            int dist = Integer.MAX_VALUE;
            int[] from = house.get(i);

            for (int j = 0; j < selected.length; j++) {
                int[] to = store.get(selected[j]);
                dist = Math.min(dist, Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]));
            }

            sum += dist;
        }

        return sum;
    }
}
