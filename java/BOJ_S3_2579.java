import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(stairs[1]);
            return;
        }

        int[] score = new int[N + 1];
        score[0] = 0;
        score[1] = stairs[1];
        score[2] = stairs[1] + stairs[2];
        for (int i = 3; i <= N; i++) {
            score[i] = Math.max(score[i - 3] + stairs[i - 1], score[i - 2]) + stairs[i];
        }

        System.out.println(score[N]);
    }
}
