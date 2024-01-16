import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_G5_5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
tc:     for (int t = 0; t < T; t++) {

            String p = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 수의 개수
            String s = br.readLine(); // 배열
            s = s.substring(1, s.length() - 1);

            String[] numbers = s.split(",");
            Deque<String> deque = new ArrayDeque<String>();
            for (int i = 0; i < n; i++) {
                deque.offer(numbers[i]);
            }

            boolean flag = true; // 순방향: true, 역방향: false
            for (int i = 0; i < p.length(); i++) {
                switch (p.charAt(i)) {
                    case 'R': // 뒤집기
                        flag = !flag;
                        break;
                    case 'D': // 버리기
                        if (deque.isEmpty()) {
                            sb.append("error\n");
                            continue tc;
                        }
                        if (flag) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                }
            }

            sb.append("[");
            while (deque.size() > 1) {
                if (flag) {
                    sb.append(deque.pollFirst()).append(",");
                } else {
                    sb.append(deque.pollLast()).append(",");
                }
            }
            if (!deque.isEmpty()) {
                sb.append(deque.poll());
            }
            sb.append("]\n");
        }

        System.out.println(sb.toString());
    }
}
