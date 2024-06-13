import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B3_5597 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] num = new boolean[31];

        for (int i = 0; i < 28; i ++) {
            num[Integer.parseInt(br.readLine())] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!num[i]) sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }
}
