import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S5_1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        char[] nums = N.toCharArray();

        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 0; i--) sb.append(nums[i]);
        System.out.println(sb.toString());
    }
}
