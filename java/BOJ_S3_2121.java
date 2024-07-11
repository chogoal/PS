import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S3_2121 {

    static int N;
    static List<Dot> list;

    static class Dot implements Comparable<Dot> {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Dot o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Dot(x, y));
        }

        Collections.sort(list);

        int cnt = 0;
        for (Dot d : list) {
            Dot d1 = new Dot(d.x + A, d.y);
            Dot d2 = new Dot(d.x, d.y + B);
            Dot d3 = new Dot(d.x + A, d.y + B);

            if (find(d1) && find(d2) && find(d3)) cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean find(Dot d) {

        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            Dot midD = list.get(mid);

            if (midD.x == d.x && midD.y == d.y) return true;

            if (midD.x < d.x) {
                lo = mid + 1;
            } else if (midD.x > d.x) {
                hi = mid - 1;
            } else { // x 같으면 y 비교
                if (midD.y < d.y) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return false;
    }
}
