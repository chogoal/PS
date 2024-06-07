import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0, b = 0;
        while (a < N && b < M) {
            if (A[a] == B[b]) {
                sb.append(A[a]).append(" ").append(B[b]);
                a++;
                b++;
            } else if (A[a] < B[b]) {
                sb.append(A[a]);
                a++;
            } else {
                sb.append(B[b]);
                b++;
            }
            sb.append(" ");
        }

        if (a == N) {
            while (b < M) {
                sb.append(B[b++]).append(" ");
            }
        }

        if (b == M) {
            while (a < N) {
                sb.append(A[a++]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
