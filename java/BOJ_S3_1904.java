import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_1904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N + 1];

        if (N == 1) System.out.println(1);
        else if (N == 2) System.out.println(2);
        else {
            array[1] = 1;
            array[2] = 2;
            for (int i = 3; i <= N; i++) {
                array[i] = (array[i - 1] + array[i - 2]) % 15746;
            }

            System.out.println(array[N]);
        }


    }
}
