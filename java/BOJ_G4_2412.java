import java.io.*;
import java.util.*;

public class BOJ_G4_2412 {

    static int n, T;
    static Set<Integer>[] pos;
    static Set<Integer>[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        pos = new HashSet[T + 1];
        visited = new HashSet[T + 1];
        for (int i = 0; i <= T; i++) {
            pos[i] = new HashSet<>();
            visited[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[y].add(x);
        }

        System.out.println(move());
    }

    private static int move() {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0, 0, 0 });

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int depth = cur[2];

            if (y == T) {
                return depth;
            }

            for (int i = 2; i >= -2; i--) {
                int ny = y + i;
                if (ny < 0 || ny > T) continue;

                for (int j = 2; j >= -2; j--) {
                    int nx = x + j;

                    if (pos[ny].contains(nx) && !visited[ny].contains(nx)) {
                        queue.offer(new int[] { nx, ny, depth + 1 });
                        visited[ny].add(nx);
                    }
                }
            }
        }

        return -1;
    }
}
