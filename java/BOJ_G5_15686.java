import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G5_15686 {

    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int[][] city; // 0: 빈 칸, 1: 집, 2: 치킨집
    static Pos[] selected; // 폐업시키지 않을 치킨집
    static ArrayList<Pos> house = new ArrayList<Pos>();
    static ArrayList<Pos> chicken = new ArrayList<Pos>();

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 1) {
                    house.add(new Pos(i, j));
                } else if (city[i][j] == 2) {
                    chicken.add(new Pos(i, j));
                }
            }
        }

        selected = new Pos[M];
        comb(0, 0);

        System.out.println(min);
    }

    private static void comb(int cnt, int start) { // M개의 치킨집 고르기

        if (cnt == M) {
            distance();
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            selected[cnt] = chicken.get(i);
            comb(cnt + 1, i + 1);
        }
    }

    private static void distance() { // 도시의 치킨 거리 구하기

        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            int x = house.get(i).x;
            int y = house.get(i).y;

            int dist = 0, minDist = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                int xx = selected[j].x;
                int yy = selected[j].y;

                dist = Math.abs(xx - x) + Math.abs(yy - y);
                minDist = Math.min(minDist, dist);
            }

            sum += minDist;
        }

        min = Math.min(min, sum);
    }
}
