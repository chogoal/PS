import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S4_18110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n];

        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(level);

        double sum = 0;
        int average = 0;

        if (n < 4) {
            for (int i = 0; i < n; i++) {
                sum += level[i];
            }
            average = (int) Math.round(sum / n);
        } else {
            int exceptCount = (int)Math.round(n * 0.15);
            for (int i = exceptCount; i < n - exceptCount; i++) {
                sum += level[i];
            }
            average = (int) Math.round(sum / (n - 2 * exceptCount));
        }

        System.out.println(average);
    }
}