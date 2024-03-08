import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] tile = new int[n + 1];

        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(3);
        } else {
            tile[1] = 1; tile[2] = 3;
            for (int i = 3; i <= n; i++) {
                tile[i] = tile[i - 1] + tile[i - 2] * 2;
                tile[i] %= 10007;
            }

            System.out.println(tile[n]);
        }
    }
}
