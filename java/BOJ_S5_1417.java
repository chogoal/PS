import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_S5_1417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int min = 0;
        while (true) {
            int top = pq.poll();
            if (top >= dasom) {
                dasom++;
                top--;
                min++;
                pq.add(top);
            } else {
                break;
            }
        }

        System.out.println(min);
    }
}
