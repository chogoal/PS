import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B2_1919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        int[] spellA = new int['z' - 'a' + 1];
        int[] spellB = new int['z' - 'a' + 1];

        for (int a = 0; a < A.length(); a++) {
            spellA[A.charAt(a) - 'a']++;
        }
        for (int b = 0; b < B.length(); b++) {
            spellB[B.charAt(b) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < spellA.length; i++) {
            if (spellA[i] != spellB[i]) {
                count += Math.abs(spellA[i] - spellB[i]);
            }
        }

        System.out.println(count);
    }
}
