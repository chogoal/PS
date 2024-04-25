import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B1_2851 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] score = new int[10];
        for (int i = 0; i < 10; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 10; i++) {
            sum2 += score[i];
            if (sum2 > 100) { sum1 = sum2 - score[i]; break; }
        }

        if (100 - sum1 < sum2 - 100) {
            System.out.println(sum1);
        } else {
            System.out.println(sum2);
        }
    }
}
