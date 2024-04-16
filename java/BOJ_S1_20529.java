import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_20529 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] mbti = new String[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) mbti[i] = st.nextToken();

            // N이 32보다 크면 무조건 최소 3명이 같은 mbti
            if (N > 32) {
                sb.append(0).append("\n");
                continue;
            }

            // mbti 비교
            int min = 100;
            for (int a = 0; a < N; a++) { // A
                for (int b = a + 1; b < N; b++) { // B
                    for (int c = b + 1; c < N; c++) { // C

                        int diff = 0;

                        // A, B 비교
                        for (int k = 0; k < 4; k++) {
                            if (mbti[a].charAt(k) != mbti[b].charAt(k)) diff++;
                        }
                        // B, C 비교
                        for (int k = 0; k < 4; k++) {
                            if (mbti[b].charAt(k) != mbti[c].charAt(k)) diff++;
                        }
                        // C, A 비교
                        for (int k = 0; k < 4; k++) {
                            if (mbti[c].charAt(k) != mbti[a].charAt(k)) diff++;
                        }

                        // 최소 갱신
                        min = Math.min(min, diff);
                    }
                }
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb.toString());
    }
}
