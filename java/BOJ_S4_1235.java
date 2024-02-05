import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S4_1235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] numbers = new String[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = br.readLine();
        }

ex:     for (int i = numbers[0].length(); i > 0; i--) {
            for (int j = 0; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (numbers[j].substring(i - 1).equals(numbers[k].substring(i - 1))) {
                        continue ex;
                    }
                }
            }
            System.out.println(numbers[0].length() - (i - 1));
            break;
        }
    }
}
