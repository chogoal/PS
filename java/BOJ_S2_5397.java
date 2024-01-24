import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S2_5397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String line = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                switch (c) {
                    case '-':
                        if (!left.empty()) left.pop();
                        break;
                    case '<':
                        if (!left.empty()) right.push(left.pop());
                        break;
                    case '>':
                        if (!right.empty()) left.push(right.pop());
                        break;
                    default:
                        left.push(c);
                }
            }

            while (!left.empty()) right.push(left.pop());
            while (!right.empty()) sb.append(right.pop());
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
