import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_2725 { // 2725. 보이는 점의 개수

    private static int[] dots = new int[1001]; // 보이는 점의 개수 저장
    private static int C;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dots[0] = 0;
        dots[1] = 3;
        cal();

        C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dots[N]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void cal() {
        for (int i = 2; i <= 1000; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (GCD(i, j) == 1) { cnt++; }
            }
            dots[i] = dots[i - 1] + cnt * 2;
        }
    }

    private static int GCD(int a, int b) {
        while(a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}
