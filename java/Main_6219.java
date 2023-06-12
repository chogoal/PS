import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_6219 { // 6219. 소수의 자격
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        String D = st.nextToken();

        boolean[] prime = new boolean[B + 1]; // 소수이면 false
        prime[0] = prime[1] = true;
        for (int i = 2; i <= B; i++) {
            if (!prime[i]) { // 소수이면, 배수들 true로 바꿔줌
                for (int j = 2; j * i <= B; j++) {
                    prime[i * j] = true;
                }
            }
        }

        int count = 0;
        for (int i = A; i <= B; i++) {
            if (prime[i]) continue;
            if (String.valueOf(i).contains(D)) count++;
        }

        System.out.println(count);
    }
}