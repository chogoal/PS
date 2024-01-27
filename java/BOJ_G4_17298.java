import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_G4_17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[N];

ex:     for (int i = N - 1; i >= 0; i--) {
            if (stack.empty()) {
                ans[i] = -1;
                stack.push(array[i]);
                continue;
            }

            int top = stack.peek();
            while (top <= array[i]) {
                stack.pop();
                if (stack.empty()) {
                    ans[i] = -1;
                    stack.push(array[i]);
                    continue ex;
                } else {
                    top = stack.peek();
                }
            }

            if (top > array[i]) {
                ans[i] = top;
                stack.push(array[i]);
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
