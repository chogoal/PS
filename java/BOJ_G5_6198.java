import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_G5_6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] height = new int[N + 1];
        height[N] = 1000000001;
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { height[N], N });

        long sum = 0;
        for (int i = N - 1; i >= 0; i--) {
            int topHeight = stack.peek()[0];
            int topIndex = stack.peek()[1];

            while (height[i] > topHeight) {
                stack.pop();
                topHeight = stack.peek()[0];
                topIndex = stack.peek()[1];
            }

            sum += (topIndex - i) - 1;
            stack.push(new int[] { height[i], i });
        }

        System.out.println(sum);
    }
}
