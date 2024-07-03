import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S3_11899 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
            }

            stack.push(c);
        }

        System.out.println(stack.size());
    }
}
