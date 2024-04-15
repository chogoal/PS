import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_7662 {

    static Queue<Integer> maxQ;
    static Queue<Integer> minQ;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());

            maxQ = new PriorityQueue<>(Collections.reverseOrder());
            minQ = new PriorityQueue<>();
            map = new HashMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String mod = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (mod.equals("I")) {
                    maxQ.offer(num);
                    minQ.offer(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                // "D"
                else {
                    if (map.isEmpty()) continue;

                    if (num == 1) delete(maxQ);
                    else delete(minQ);
                }
            }

            // 최대, 최소
            if (map.isEmpty()) sb.append("EMPTY");
            else {
                int max = delete(maxQ);
                sb.append(max).append(" ");

                if (map.isEmpty()) sb.append(max);
                else sb.append(delete(minQ));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int delete(Queue<Integer> q) {

        int key;
        while (true) {
            key = q.poll();
            int cnt = map.getOrDefault(key, 0);
            if (cnt == 0) continue;

            if (cnt == 1) map.remove(key);
            else map.put(key, cnt - 1);

            break;
        }

        return key;
    }
}
