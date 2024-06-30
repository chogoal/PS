import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_25577 {

    static int N;
    static int[] A, arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        arr = new int[N];
        visited = new boolean[N];
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            arr[i] = A[i];
        }

        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            map.put(A[i], i);
        }

        for (int i = 0; i < N; i++) {
            arr[i] = map.get(arr[i]);
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i);
            }
        }

        System.out.println(N - cnt);
    }

    private static void dfs(int idx) {

        visited[idx] = true;
        if (!visited[arr[idx]]) {
            dfs(arr[idx]);
        }
    }
}
