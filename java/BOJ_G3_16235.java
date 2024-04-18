import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G3_16235 {

    static int N, M, K;
    static int[][] A; // 추가되는 양분
    static int[][] ground; // 현재 땅의 양분
    static Deque<Integer>[][] tree; // 각 칸의 나무들 나이
    static List<int[]> growTree; // 번식하는 나무들 (나이가 5의 배수)

    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        ground = new int[N][N];
        tree = new Deque[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());

                ground[i][j] = 5;
                tree[i][j] = new ArrayDeque<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());

            tree[x][y].offer(age);
        }

        while (K-- > 0) {
            growTree = new ArrayList<>();

            springAndSummer();
            autumn();
            winter();
        }

        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                num += tree[i][j].size();
            }
        }

        System.out.println(num);
    }

    private static void springAndSummer() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tree[i][j].isEmpty()) continue;

                int deadTree = 0;
                int size = tree[i][j].size();
                for (int k = 0; k < size; k++) {
                    int age = tree[i][j].poll();
                    int food = ground[i][j];

                    // 양분 부족하면 나이/2 만큼의 양분 제공 후 사망
                    if (age > food) deadTree += age / 2;
                    else {
                        ground[i][j] -= age;
                        tree[i][j].offer(age + 1);

                        // 나무 나이가 5의 배수이면 번식 나무 리스트에 추가
                        if ((age + 1) % 5 == 0) growTree.add(new int[] { i, j });
                    }
                }

                ground[i][j] += deadTree;
            }
        }
    }

    private static void autumn() {
        for (int[] pos : growTree) {
            for (int d = 0; d < 8; d++) {
                int nx = pos[0] + dx[d];
                int ny = pos[1] + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                tree[nx][ny].offerFirst(1);
            }
        }
    }

    private static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ground[i][j] += A[i][j];
            }
        }
    }
}
