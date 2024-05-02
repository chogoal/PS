import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_1182 {

    static int N, S;
    static int[] numbers;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        subset(0, 0);

        // S == 0이면 공집합(부분집합 중 원소 합이 0)이 되는 경우 제외해주기
        System.out.println(S == 0 ? count - 1 : count);
    }

    private static void subset(int cnt, int sum) {

        if (cnt == N) {
            if (sum == S) count++;
            return;
        }

        subset(cnt + 1, sum); // 현재 원소 포함하지 않는 부분집합
        subset(cnt + 1, sum + numbers[cnt]); // 현재 원소 포함하는 부분집합
    }
}