import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_S3_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> queue = new LinkedList<int[]>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.offer(new int[] { i, Integer.parseInt(st.nextToken())}); // 순서, 중요도
            }

            int cnt = 0;
            while (!queue.isEmpty()) {

                int[] first = queue.poll(); // 첫번째 원소
                boolean isMax = true; // 첫번째 원소가 가장 큰 원소인지 판단

                for (int i = 0; i < queue.size(); i++) {
                    if (first[1] < queue.get(i)[1]) {
                        queue.offer(first);
                        for (int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if (isMax) { // 첫번째 원소가 가장 큰 원소라면, 출력
                    cnt++;
                    if (first[0] == M) break; // 찾는 문서라면 반복문 종료
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
