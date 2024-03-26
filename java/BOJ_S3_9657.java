import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_9657 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1 || N == 3 || N == 4) System.out.println("SK"); // true
        else if (N == 2) System.out.println("CY"); // false
        else {
            boolean[] winner = new boolean[N + 1];
            winner[1] = winner[3] = winner[4] = true;

            for (int i = 5; i <= N; i++) {
                winner[i] = !winner[i - 4] || !winner[i - 3] || !winner[i - 1];
            }

            System.out.println(winner[N] ? "SK" : "CY");
        }
    }
}
