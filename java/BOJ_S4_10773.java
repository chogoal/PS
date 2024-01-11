import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S4_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) {
                stack.pop();
            } else {
                stack.push(k);
            }
        }

        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
