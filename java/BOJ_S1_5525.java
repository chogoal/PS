import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int cnt = 0; // OI 개수
        int ans = 0; // 패턴 개수

        for (int i = 1; i < M - 1; ) {
            if (S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                cnt++;
                if (cnt == N) {
                    if (S.charAt((i + 1) - 2 * N) == 'I') {
                        ans++;
                    }
                    cnt--;
                }
                i += 2;
            } else {
                cnt = 0;
                i++;
            }
        }

        System.out.println(ans);
    }
}
