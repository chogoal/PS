import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_14718 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] points = new int[N][3];
        int[] a = new int[N]; // 힘
        int[] b = new int[N]; // 민첩
        int[] c = new int[N]; // 지능

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
            points[i][2] = Integer.parseInt(st.nextToken());

            a[i] = points[i][0];
            b[i] = points[i][1];
            c[i] = points[i][2];
        }

        int min = 3000001;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {

                    int count = 0;
                    for (int n = 0; n < N; n++) {
                        if (points[n][0] <= a[i] && points[n][1] <= b[j] && points[n][2] <= c[k]) {
                            count++;
                        }
                    }

                    if (count >= K) min = Math.min(min, a[i] + b[j] + c[k]);
                }
            }
        }

        System.out.println(min);
    }
}
