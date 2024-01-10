import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S4_4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            String line = br.readLine();
            if (line.equals(".")) break;

            Stack<Character> stack = new Stack<Character>();
            boolean balance = true; // 현재 문자열이 균형을 이루는 지 여부

ex:         for (int i = 0; i < line.length(); i++) {
                switch (line.charAt(i)) {
                    case '(':
                    case '[':
                        stack.push(line.charAt(i));
                        break;
                    case ')':
                        if (!stack.empty() && stack.pop() == '(') break;
                        sb.append("no").append("\n");
                        balance = false;
                        break ex;
                    case ']':
                        if (!stack.empty() && stack.pop() == '[') break;
                        sb.append("no").append("\n");
                        balance = false;
                        break ex;
                }
            }

            if (balance) {
                if (stack.empty()) { // 스택이 비어있다면
                    sb.append("yes").append("\n");
                } else {
                    sb.append("no").append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
