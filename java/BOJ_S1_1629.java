import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_1629 {

    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B));
    }

    // 거듭제곱 수행
    private static long pow(long A, long B) {

        if (B == 1) {
            return A % C;
        }

        // 지수의 절반 값 구하기
        long half = pow(A, B / 2);

        // 지수가 홀수일 경우, 한 번 더 곱해주기
        if (B % 2 == 1) {
            return ((half * half % C) * (A % C)) % C;
        } else {
            return ((half % C) * (half % C)) % C;
        }
    }
}
