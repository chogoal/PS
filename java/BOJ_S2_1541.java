import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] formula = br.readLine().split("-");

        int sum = 0;
        String[] first = formula[0].split("\\+");
        for (int i = 0; i < first.length; i++) {
            sum += Integer.parseInt(first[i]);
        }

        for (int i = 1; i < formula.length; i++) {
            int nextSum = 0;
            String[] next = formula[i].split("\\+");
            for (int j = 0; j < next.length; j++) {
                nextSum += Integer.parseInt(next[j]);
            }
            sum -= nextSum;
        }

        System.out.println(sum);
    }
}
