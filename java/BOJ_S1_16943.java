import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_16943 {

    static String A;
    static int B, len;
    static int[] nums;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = Integer.parseInt(st.nextToken());
        len = A.length();

        nums = new int[len];
        visited = new boolean[len];

        for (int i = 0; i < len; i++) {
            nums[i] = A.charAt(i) - '0';
        }

        perm(0, "");

        System.out.println(max == Integer.MIN_VALUE ? -1 : max);
    }

    private static void perm(int cnt, String C) {

        if (cnt == len) {
            if (!C.equals(A) && Integer.parseInt(C) < B) {
                max = Math.max(max, Integer.parseInt(C));
            }
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            if (cnt == 0 && nums[i] == 0) continue;
            visited[i] = true;
            perm(cnt + 1, C + nums[i]);
            visited[i] = false;
        }
    }
}
