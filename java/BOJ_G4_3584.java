import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_G4_3584 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            int N = Integer.parseInt(br.readLine());
            int[] parent = new int[N + 1];

            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                parent[v] = u; // 자식 -> 부모
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Stack<Integer> parentA = new Stack<>();
            Stack<Integer> parentB = new Stack<>();

            // A의 조상 (0이면 루트)
            while (A != 0) {
                parentA.push(A);
                A = parent[A];
            }

            // B의 조상
            while (B != 0) {
                parentB.push(B);
                B = parent[B];
            }

            int common = 0; // 공통 조상
            while (!parentA.empty() && !parentB.empty()) {
                int pa = parentA.pop();
                int pb = parentB.pop();

                if (pa == pb) common = pa;
                else break;
            }

            sb.append(common).append("\n");
        }

        System.out.println(sb.toString());
    }
}
