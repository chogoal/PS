import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B4_11365 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String code = br.readLine();

            if (code.equals("END")) break;

            for (int i = code.length() - 1; i >= 0; i--) {
                sb.append(code.charAt(i));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
