import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();
        int[] count = new int[10]; // 0~9
        for (int i = 0; i < number.length(); i++) {
            int n = number.charAt(i) - '0';
            if (n == 9) n = 6;
            count[n]++;
        }

        int max = 0;
        count[6] = (count[6] + 1) / 2;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, count[i]);
        }

        System.out.println(max);
    }
}
