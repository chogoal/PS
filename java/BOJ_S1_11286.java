import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_S1_11286 {

    static class Num implements Comparable<Num> {
        int x;
        int abs;

        public Num(int x) {
            this.x = x;
            this.abs = Math.abs(x);
        }

        public int compareTo(Num o) {
            if (this.abs != o.abs) {
                return this.abs - o.abs;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Num> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) sb.append(pq.size() == 0 ? 0 : pq.poll().x).append("\n");
            else pq.offer(new Num(x));
        }

        System.out.println(sb.toString());
    }
}
