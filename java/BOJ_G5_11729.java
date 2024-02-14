import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_11729 {

    static int N;
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);

        System.out.println(count);
        System.out.println(sb.toString());
    }

    private static void hanoi(int n, int from, int mid, int to) {

        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            count++;
        } else {
            hanoi(n - 1, from, to, mid);
            sb.append(from).append(" ").append(to).append("\n");
            count++;
            hanoi(n - 1, mid, from, to);
        }
    }
}
