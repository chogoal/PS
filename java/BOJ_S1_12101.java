import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S1_12101 {

    static int n, k;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        sum(0, "");

        if (list.size() < k) sb.append(-1);
        else {
            String nums = list.get(k - 1);
            for (int i = 0; i < nums.length() - 1; i++) {
                sb.append(nums.charAt(i)).append("+");
            }
            sb.append(nums.charAt(nums.length() - 1));
        }

        System.out.println(sb.toString());
    }

    private static void sum(int value, String nums) {

        if (value == n) {
            list.add(nums);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (value + i > n) break;
            sum(value + i, nums + i);
        }
    }
}
