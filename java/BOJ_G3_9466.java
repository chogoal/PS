import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_9466 {

    static int n;
    static int[] choice;
    static int[] team; // 팀 결성 확인 여부
    static int[] visited; // 방문 체크
    static int count; // 팀을 결성한 학생 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            choice = new int[n];
            team = new int[n];
            visited = new int[n];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                choice[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                if (team[i] == 0) {
                    dfs(i);
                }
            }

            sb.append(n - count).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int i) {

        if (visited[i] == 1) {
            team[i] = 1;
            count++;
        } else {
            visited[i] = 1;
        }

        int next = choice[i] - 1;
        if (team[next] == 0) { // 다음 학생의 팀 결성 여부를 확인하지 않았다면,
            dfs(next);
        }

        visited[i] = 0; // 방문 체크 해제 (새로운 탐색)
        team[i] = 1; // 팀 결성 여부 확인 체크
    }
}