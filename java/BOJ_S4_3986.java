import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S4_3986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() % 2 != 0) {
                continue;
            }

            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < word.length(); j++) {
                if (stack.empty()) {
                    stack.push(word.charAt(j));
                } else {
                    int top = stack.peek();
                    if (top == word.charAt(j)) {
                        stack.pop();
                    } else {
                        stack.push(word.charAt(j));
                    }
                }
            }

            if (stack.empty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
