import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B3_2490 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String abcde = "EABCD";
        char[] array = abcde.toCharArray();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int zero = 0;
            for (int j = 0; j < 4; j++) {
                if (st.nextToken().equals("0")) zero++;
            }

            sb.append(array[zero]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
