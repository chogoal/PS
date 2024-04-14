import java.io.*;
import java.util.*;

public class BOJ_G4_9019 {

    static int A, B;
    static String answer;

    static class Register {
        int num;
        String cmd; // 명령어 히스토리

        public Register(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            cal();

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void cal() {

        Queue<Register> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10000]; // 0 ~ 9999

        queue.offer(new Register(A, ""));
        visited[A] = true;

        while (!queue.isEmpty()) {
            Register reg = queue.poll();

            if (reg.num == B) { answer = reg.cmd; return; }

            int d = D(reg.num);
            if (!visited[d]) {
                queue.add(new Register(d, reg.cmd + "D"));
                visited[d] = true;
            }

            int s = S(reg.num);
            if (!visited[s]) {
                queue.add(new Register(s, reg.cmd + "S"));
                visited[s] = true;
            }

            int l = L(reg.num);
            if (!visited[l]) {
                queue.add(new Register(l, reg.cmd + "L"));
                visited[l] = true;
            }

            int r = R(reg.num);
            if (!visited[r]) {
                queue.add(new Register(r, reg.cmd + "R"));
                visited[r] = true;
            }
        }
    }

    private static int D(int n) {
        return 2 * n % 10000;
    }

    private static int S(int n) {
        return n == 0 ? 9999 : n - 1;
    }

    private static int L(int n) {
        return n % 1000 * 10 + n / 1000;
    }

    private static int R(int n) {
        return n % 10 * 1000 + n / 10;
    }
}
