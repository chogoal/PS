import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S2_1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<String> left = new Stack<String>();
        Stack<String> right = new Stack<String>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            left.push(String.valueOf(s.charAt(i)));
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "P":
                    left.push(st.nextToken());
                    break;
                case "L":
                    if (!left.empty()) right.push(left.pop());
                    break;
                case "D":
                    if (!right.empty()) left.push(right.pop());
                    break;
                case "B":
                    if (!left.empty()) left.pop();
                    break;
            }
        }

        while (!left.empty()) {
            right.push(left.pop());
        }
        while(!right.empty()) {
            sb.append(right.pop());
        }
        System.out.println(sb.toString());
    }
}
