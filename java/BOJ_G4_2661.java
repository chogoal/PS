import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G4_2661 {

    static int N;
    static String min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        make(0, "");

        System.out.println(min);
    }

    private static boolean make(int cnt, String num) {

        if (cnt == N) {
            min = num;
            return true;
        }

        for (int i = 1; i <= 3; i++) {
            if (check(num + i) && make(cnt + 1, num + i)) return true;
        }

        return false;
    }

    private static boolean check(String num) {

        int len = num.length();
        if (len == 1) return true;

        for (int i = len - 2, cnt = 1; i >= 0; i -= 2, cnt++) {
            if (num.substring(i, i + cnt).equals(num.substring(i + cnt, len))) {
                return false;
            }
        }
        return true;
    }
}
