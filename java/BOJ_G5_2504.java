import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_G5_2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        int mul = 1;
        int answer = 0;

        String line = br.readLine();
ex:     for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            switch (c) {
                case '(':
                    mul *= 2;
                    stack.push(c);
                    break;
                case '[':
                    mul *= 3;
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty() || stack.peek() != '(') {
                        answer = 0;
                        break ex;
                    }

                    // 바로 이전값이 여는 괄호였는지 확인
                    if (line.charAt(i - 1) == '(') {
                        answer += mul;
                    }

                    stack.pop();
                    mul /= 2;
                    break;
                case ']':
                    if (stack.empty() || stack.peek() != '[') {
                        answer = 0;
                        break ex;
                    }

                    // 바로 이전값이 여는 괄호였는지 확인
                    if (line.charAt(i - 1) == '[') {
                        answer += mul;
                    }

                    stack.pop();
                    mul /= 3;
                    break;
            }
        }

        answer = stack.empty() ? answer : 0;
        System.out.println(answer);
    }
}
