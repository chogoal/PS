import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            people[i][1] = Integer.parseInt(st.nextToken()); // 키
        }

        int[] rank = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                    rank[i]++;
                } else if (people[j][0] < people[i][0] && people[j][1] < people[i][1]) {
                    rank[j]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(rank[i] + 1).append(" ");
        }
        System.out.println(sb.toString());
    }
}
