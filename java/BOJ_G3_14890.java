import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_14890 {

    static int N, L;
    static int[][] map;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        passRow();
        passCol();

        System.out.println(count);
    }

    private static void passRow() {

        for (int i = 0; i < N; i++) {

            int beforeCnt = 1; // 현재 칸 이전의 높이가 같고 연속된 칸들의 개수
            boolean isPath = true;

            ex:
            for (int j = 1; j < N; j++) {

                // 현재 칸의 높이가 직전 칸과 같으면 다음 칸 탐색
                if (map[i][j] == map[i][j - 1]) { beforeCnt++; continue; }

                // 현재 칸의 높이가 직전 칸보다 2칸 이상 높거나 낮으면, 행 탐색 종료
                if (map[i][j] > map[i][j - 1] + 1 || map[i][j] < map[i][j - 1] - 1) {
                    isPath = false;
                    break;
                }

                // 현재 칸의 높이가 직전 칸보다 한 칸 높으면, 직전 칸에 경사로를 놓을 수 있는지 확인
                if (map[i][j] == map[i][j - 1] + 1) {
                    if (beforeCnt < L) { isPath = false; break; }
                    beforeCnt = 1;
                    continue;
                }

                // 현재 칸의 높이가 직전 칸보다 한 칸 낮으면, 이후 L개의 칸이 같은 높이인지 확인
                if (map[i][j] == map[i][j - 1] - 1) {
                    for (int l = 0; l < L; l++) {
                        if (j + l >= N) { isPath = false; break ex; } // 범위 벗어날 경우
                        if (map[i][j + l] != map[i][j]) { isPath = false; break ex; } // 경사로를 놓을 공간이 부족한 경우
                    }
                    j += L - 1;
                    beforeCnt = 0;
                }
            }

            if (isPath) count++;
        }
    }

    private static void passCol() {

        for (int j = 0; j < N; j++) {

            int beforeCnt = 1; // 현재 칸 이전의 높이가 같고 연속된 칸들의 개수
            boolean isPath = true;

            ex:
            for (int i = 1; i < N; i++) {

                if (map[i][j] == map[i - 1][j]) { beforeCnt++; continue; }

                if (map[i][j] > map[i - 1][j] + 1 || map[i][j] < map[i - 1][j] - 1) { isPath = false; break; }

                if (map[i][j] == map[i - 1][j] + 1) {
                    if (beforeCnt < L) { isPath = false; break; }
                    beforeCnt = 1; continue;
                }

                if (map[i][j] == map[i - 1][j] - 1) {
                    for (int l = 0; l < L; l++) {
                        if (i + l >= N) { isPath = false; break ex; }
                        if (map[i + l][j] != map[i][j]) { isPath = false; break ex; }
                    }
                    i += L - 1;
                    beforeCnt = 0;
                }
            }

            if (isPath) count++;
        }
    }
}
