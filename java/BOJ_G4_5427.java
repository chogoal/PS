import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_5427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] building = new char[h + 2][w + 2];

            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(building[i], '-'); // 출구
            }

            Queue<int[]> fire = new ArrayDeque<int[]>(); // 불
            Queue<int[]> person = new ArrayDeque<int[]>(); // 상근

            for (int i = 1; i < h + 1; i++) {
                String s = br.readLine();
                for (int j = 1; j < w + 1; j++) {
                    building[i][j] = s.charAt(j - 1);
                    if (building[i][j] == '*') {
                        fire.offer(new int[] { i, j });
                    } else if (building[i][j] == '@') {
                        person.offer(new int[] { i, j });
                        building[i][j] = '+'; // 지나간 자리 표시
                    }
                }
            }

            int time = 0;
            boolean exit = false;

ex:         while (true) {

                // 이동 방향
                int[] dx = { 0, 1, 0, -1 };
                int[] dy = { 1, 0, -1, 0 };

                // 불의 이동
                int fireSize = fire.size();
                while (fireSize-- > 0) {
                    int[] fireNow = fire.poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = fireNow[0] + dx[d];
                        int ny = fireNow[1] + dy[d];

                        if (nx >= 0 && nx < h + 2 && ny >= 0 && ny < w + 2) {
                            if (building[nx][ny] == '.' || building[nx][ny] == '+') {
                                fire.offer(new int[] { nx, ny });
                                building[nx][ny] = '*';
                            }
                        }
                    }
                }

                // 상근이의 이동
                if (person.isEmpty()) { // 상근이가 더 이상 이동할 곳이 없다면
                    break;
                }

                int personSize = person.size();
                while (personSize-- > 0) {
                    int[] personNow = person.poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = personNow[0] + dx[d];
                        int ny = personNow[1] + dy[d];

                        if (nx >= 0 && nx < h + 2 && ny >= 0 && ny < w + 2) {
                            if (building[nx][ny] == '-') { // 출구이면 탈출 성공
                                ++time;
                                exit = true;
                                break ex;
                            } else if (building[nx][ny] == '.') {
                                person.offer(new int[] { nx, ny });
                                building[nx][ny] = '+';
                            }
                        }
                    }
                }

                time++;
            }

            if (exit) {
                sb.append(time).append("\n");
            } else {
                sb.append("IMPOSSIBLE").append("\n");
            }

        }
        System.out.println(sb.toString());
    }
}
