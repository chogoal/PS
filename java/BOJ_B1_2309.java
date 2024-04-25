import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_B1_2309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] heights = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }

        Arrays.sort(heights);

        int f1 = -1, f2 = -1;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (heights[i] + heights[j] == sum - 100) { f1 = i; f2 = j; break; }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == f1 || i == f2) continue;
            sb.append(heights[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
