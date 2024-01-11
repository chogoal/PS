import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S3_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int sum = 0;
        int max = -4001;
        int min = 4001;
        int[] count = new int[8001]; // 등장 횟수

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            array[i] = n;

            sum += n;
            if (n > max) max = n;
            if (n < min) min = n;
            count[n + 4000]++;
        }

        // 산술평균
        Arrays.sort(array);
        sb.append((int)Math.round((double)sum / N)).append("\n");

        // 중앙값
        sb.append(array[N / 2]).append("\n");

        // 최빈값
        int maxCount = 0;
        int[] modes = new int[2];
        for (int i = 0; i < count.length; i++) {
            if (maxCount < count[i]) {
                maxCount = count[i];
                modes[0] = i - 4000;
                modes[1] = 9999;
            } else if (maxCount == count[i] && modes[1] == 9999) {
                modes[1] = i - 4000;
            }
        }
        if (modes[1] == 9999) sb.append(modes[0]);
        else sb.append(modes[1]);
        sb.append("\n");

        // 범위
        sb.append(max - min);

        System.out.println(sb.toString());
    }
}
