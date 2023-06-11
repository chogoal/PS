import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_9417 { // 9417. 최대 GCD
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            List<Integer> nums = new ArrayList<Integer>();

            while (st.hasMoreTokens()) {
                nums.add(Integer.parseInt(st.nextToken()));
            }

            int max = 0;
            for (int a = 0; a < nums.size() - 1; a++) {
                for (int b = a + 1; b < nums.size(); b++) {
                    int gcd = GCD(nums.get(a), nums.get(b));
                    if (gcd > max) { max = gcd; }
                }
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}