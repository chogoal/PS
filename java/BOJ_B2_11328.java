import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_11328 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
tc:     for (int i = 0; i < N; i++) {
            int[] alphabet = new int['z' - 'a' + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            for (int f = 0; f < first.length(); f++) {
                alphabet[first.charAt(f) - 'a']++;
            }

            for (int s = 0; s < second.length(); s++) {
                int index = second.charAt(s) - 'a';
                if (alphabet[index] <= 0) {
                    sb.append("Impossible\n");
                    continue tc;
                }
                alphabet[index]--;
            }

            for (int a = 0; a < alphabet.length; a++) {
                if (alphabet[a] > 0) {
                    sb.append("Impossible\n");
                    continue tc;
                }
            }

            sb.append("Possible\n");
        }

        System.out.println(sb.toString());
    }
}
