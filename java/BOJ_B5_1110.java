import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B5_1110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int newN = N;
        int cycle = 0;

        do {
            int sum = newN / 10 + newN % 10;
            newN = newN % 10 * 10 + sum % 10;
            cycle++;
        } while (newN != N);

        System.out.println(cycle);
    }
}
