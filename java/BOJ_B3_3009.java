import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B3_3009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] num = new int[1001][2];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            num[x][0]++;
            num[y][1]++;
        }

        int x = 0, y = 0;
        for (int i = 1; i <= 1000; i++) {
            if (num[i][0] == 1) x = i;
            if (num[i][1] == 1) y = i;
        }

        System.out.println(x + " " + y);
    }
}
