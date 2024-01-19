import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_B4_2752 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] array = new int[3];
        for (int i = 0; i < 3; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        for (int a : array) {
            sb.append(a).append(" ");
        }
        System.out.println(sb.toString());
    }
}
