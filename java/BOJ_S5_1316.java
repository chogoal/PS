import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            int[] alphabet = new int['z' - 'a' + 1];
            String word = br.readLine();

            for (int j = 0; j < word.length(); j++) {
                char w = word.charAt(j);

                if (alphabet[w - 'a'] == 0 || alphabet[w - 'a'] == j) {
                    alphabet[w - 'a'] = j + 1;
                } else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(N - count);
    }
}
