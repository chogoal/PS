import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 18310. 안테나 문제를 2차원으로 확장
// x, y를 분리해서 계산 (서로 영향을 주지 않음)
public class Main_14400 { // 14400. 편의점 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x);
        Arrays.sort(y);

        int storeX = x[(n - 1) / 2];
        int storeY = y[(n - 1) / 2];

        long sum = 0; // int 범위 벗어남
        for (int i = 0; i < n; i++) {
            sum += Math.abs(storeX - x[i]) + Math.abs(storeY - y[i]);
        }

        System.out.println(sum);

    }
}