import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G4_24956 {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        long w = 0, wh = 0, whe = 0, whee = 0;
        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);

            switch (c) {
                case 'W':
                    w += 1;
                    break;
                case 'H':
                    wh += w;
                    break;
                case 'E':
                    whee *= 2;
                    whee += whe;
                    whee %= MOD;

                    whe += wh;
                    break;
            }
        }

        System.out.println(whee);
    }
}
