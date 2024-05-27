import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B1_4344 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int[] score = new int[N];

            int sum = 0;
            for (int j = 0; j < N; j++) {
                score[j] = Integer.parseInt(st.nextToken());
                sum += score[j];
            }

            double avg = (double) sum / N;
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (score[j] > avg) count++;
            }

            double ratio = (double) count / N * 100;
            ratio = Math.round(ratio * 1000) / 1000.0;
            sb.append(String.format("%.3f", ratio)).append("%\n");
        }

        System.out.println(sb.toString());
    }
}
