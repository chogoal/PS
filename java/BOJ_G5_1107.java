import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_1107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if (M == 0) {
            System.out.println(Math.min(Math.abs(N - 100), String.valueOf(N).length()));
            return;
        }

        boolean[] broken = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            broken[Integer.parseInt(st.nextToken())] = true; // 고장난 번호
        }

        int ans = Math.abs(N - 100);

        for (int i = 0; i < 1000000; i++) {
            String num = String.valueOf(i);
            boolean check = false;
            for (int j = 0; j < num.length(); j++) {
                if (broken[num.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                ans = Math.min(Math.abs(N - i) + num.length(), ans);
            }
        }

        System.out.println(ans);
    }
}
