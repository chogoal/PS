import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_2487 {

    static int N;
    static int[] order;
    static boolean[] visited, done;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        order = new int[N + 1];
        visited = new boolean[N + 1];
        done = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> sizeSet = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                size = 1;
                dfs(i, 1);
                sizeSet.add(size);
            }
        }

        List<Integer> sizeList = new ArrayList<>(sizeSet);
        Collections.sort(sizeList, Collections.reverseOrder());

        long lcm = sizeList.get(0);
        for (int i = 1; i < sizeList.size(); i++) {
            int n = sizeList.get(i);
            lcm = lcm * n / gcd(lcm, n);
        }

        System.out.println(lcm);
    }

    private static void dfs(int idx, int cnt) {

        visited[idx] = true;

        int next = order[idx];
        if (!visited[next]) {
            dfs(next, cnt + 1);
        } else if (!done[next]) {
            size = cnt;
        }

        done[idx] = true;
    }

    // lcm = a * b / gcd(a, b);
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
