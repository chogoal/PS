import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_17140 {

    static int[][] array;
    static List<PriorityQueue<Pair>> list;

    static class Pair implements Comparable<Pair> {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.cnt != this.cnt) {
                return this.cnt - o.cnt;
            }
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());
        array = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            if (r < array.length && c < array[0].length && array[r][c] == k) break;

            time++;
            if (time == 101) break;

            list = new ArrayList<>();
            op();
        }

        System.out.println(time == 101 ? -1 : time);
    }

    private static void op() {

        int r = array.length;
        int c = array[0].length;

        if (r >= c) opR(r, c);
        else opC(r, c);
    }

    private static void opR(int r, int c) {

        // 모든 행에 대해 연산 수행
        for (int i = 0; i < r; i++) {

            // 각각의 수가 몇 번 나왔는지 체크
            int[] count = new int[101];
            for (int j = 0; j < c; j++) {
                count[array[i][j]]++;
            }

            // 정렬
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            for (int j = 1; j <= 100; j++) {
                if (count[j] > 0) {
                    pq.add(new Pair(j, count[j]));
                }
            }

            list.add(pq);
        }

        // pq 중 가장 긴 길이 찾기
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i).size());
        }

        // 가장 긴 길이에 맞춰 배열 갱신
        array = new int[r][max * 2];
        for (int i = 0; i < list.size(); i++) {

            int idx = 0;
            while (!list.get(i).isEmpty()) {
                Pair p = list.get(i).poll();

                array[i][idx++] = p.num;
                array[i][idx++] = p.cnt;
            }

            for (int j = idx; j < max; j++) {
                array[i][j] = 0;
            }
        }
    }

    private static void opC(int r, int c) {

        // 모든 열에 대해 연산 수행
        for (int i = 0; i < c; i++) {

            // 각각의 수가 몇 번 나왔는지 체크
            int[] count = new int[101];
            for (int j = 0; j < r; j++) {
                count[array[j][i]]++;
            }

            // 정렬
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            for (int j = 1; j <= 100; j++) {
                if (count[j] > 0) {
                    pq.add(new Pair(j, count[j]));
                }
            }

            list.add(pq);
        }

        // pq 중 가장 긴 길이 찾기
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i).size());
        }

        // 가장 긴 길이에 맞춰 배열 갱신
        array = new int[max * 2][c];
        for (int i = 0; i < list.size(); i++) {

            int idx = 0;
            while (!list.get(i).isEmpty()) {
                Pair p = list.get(i).poll();

                array[idx++][i] = p.num;
                array[idx++][i] = p.cnt;
            }

            for (int j = idx; j < max; j++) {
                array[j][i] = 0;
            }
        }
    }
}
