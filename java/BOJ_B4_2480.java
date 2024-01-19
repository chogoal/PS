import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B4_2480 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cnt = new int[7];
        for (int i = 0; i < 3; i++) {
            cnt[Integer.parseInt(st.nextToken())]++;
        }

        int max = 0;
        int price = 0;
        for (int i = 1; i < 7; i++) {
            if (cnt[i] == 3) {
                price = 10000 + i * 1000;
                break;
            }
            if (cnt[i] == 2) {
                price = 1000 + i * 100;
                break;
            }
            if (cnt[i] == 1) {
                max = Math.max(max, i);
            }
        }

        if (price > 0) {
            System.out.println(price);
        } else {
            System.out.println(max * 100);
        }
    }
}
