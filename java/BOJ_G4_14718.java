import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_14718 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] points = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
            points[i][2] = Integer.parseInt(st.nextToken());
        }

        int min = 3000001;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {

                    int count = 0;
                    for (int n = 0; n < N; n++) {
                        if (points[n][0] <= points[i][0] &&
                            points[n][1] <= points[j][1] &&
                            points[n][2] <= points[k][2]) count++;
                    }

                    if (count >= K) {
                        min = Math.min(min, points[i][0] + points[j][1] + points[k][2]);
                    }
                }
            }
        }

        System.out.println(min);
    }
}
