import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B4_5596 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer first = new StringTokenizer(br.readLine());
        StringTokenizer second = new StringTokenizer(br.readLine());

        int S = 0, T = 0;
        for (int i = 0; i < 4; i++) {
            S += Integer.parseInt(first.nextToken());
            T += Integer.parseInt(second.nextToken());
        }

        System.out.println(Math.max(S, T));
    }
}
