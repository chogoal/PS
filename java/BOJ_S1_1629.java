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

        // C로 모듈러 연산 (x * y) % z = (x % z) * (y % z) % z
        long answer = (half % C) * (half % C) % C;

        // 지수가 홀수일 경우, 한 번 더 곱해주기
        if (B % 2 == 0) {
            return answer;
        } else {
            return answer * (A % C) % C;
        }
    }
}
