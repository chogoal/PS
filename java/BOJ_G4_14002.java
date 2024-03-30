import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_G4_14002 {

    static int N;
    static int[] array;
    static int[] dp;
    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        array = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        find();

        sb.append(stack.size()).append("\n");
        while (!stack.empty()) {
            sb.append(array[stack.pop()]).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void find() {

        // dp 배열 채우기
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // 가장 긴 수열 길이와 최대값 찾기
        int max = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > max) { max = dp[i]; idx = i; }
        }

        // 증가하는 수열 찾기
        stack.push(idx);
        for (int i = idx - 1; i >= 0; i--) {
            if (dp[i] == dp[stack.peek()] - 1) {
                stack.push(i);
            }
        }
    }
}
