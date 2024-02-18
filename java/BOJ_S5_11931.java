import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_S5_11931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Integer[] number = new Integer[N];

        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(number, Collections.reverseOrder());

        for (int n : number) {
            sb.append(n).append("\n");
        }

        System.out.println(sb.toString());
    }
}
