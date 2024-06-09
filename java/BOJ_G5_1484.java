import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_1484 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int G = Integer.parseInt(br.readLine());

        int now = 2, prev = 1;
        boolean check = false;
        while (now < 100000) {
            long diff = now * now - prev * prev;

            if (diff == G) {
                sb.append(now).append("\n");
                check = true;
                now++;
                prev++;
            } else if (diff < G) {
                now++;
            } else {
                prev++;
            }
        }

        if (check) System.out.println(sb.toString());
        else System.out.println(-1);
    }
}
