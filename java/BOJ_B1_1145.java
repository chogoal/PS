import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B1_1145 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[5];
        for (int i = 0; i < 5; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int i = 1;
        for (; i < 1000000; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (i % num[j] == 0) cnt++;
            }

            if (cnt >= 3) break;
        }

        System.out.println(i);
    }
}
