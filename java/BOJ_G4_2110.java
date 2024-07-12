import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_2110 {

    static int N, C;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        System.out.println(binary());
    }

    private static int binary() {

        int lo = 1, hi = house[N - 1] - house[0] + 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (check(mid)) lo = mid;
            else hi = mid;
        }

        return lo;
    }

    private static boolean check(int n) {

        int cnt = 1;
        int pos = house[0];

        for (int i = 1; i < N; i++) {
            if (pos + n <= house[i]) { // 설치 가능 (최소 거리 만족)
                cnt++;
                pos = house[i];
            }
            if (cnt == C) return true;
        }

        return false;
    }
}
