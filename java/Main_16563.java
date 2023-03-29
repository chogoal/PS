
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소인수분해
// 에라토스테네스의 체
// 소수인지(0) 아닌지(1)를 저장해놓은 배열
// 배열의 앞에서부터 탐색하면서, 소수이면 해당 수의 배수 칸의 값을 1로 갱신


public class Main_16563 { // 16563.  어려운 소인수분해
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 소수 배열 만들기 -> 가장 작은 소인수 저장
		int[] prime = new int[500_0000];
		prime[0] = prime[1] = 1;
		for (int i = 2; i < prime.length; i++) {
			if (prime[i] == 0) { // 소수이면
				prime[i] = i; // 자기 자신 저장
				for (int j = i * 2; j < prime.length; j += i) {
					if (prime[j] == 0) {
						prime[j] = i; // 소수의 배수들에도 소수 저장
					}
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int K = Integer.parseInt(st.nextToken());
			// k의 소인수 출력
			while (K > 1) {
				if (prime[K] == K) { // 소수이면 종료
					sb.append(K);
					break;
				}
				sb.append(prime[K]).append(" ");
				K /= prime[K]; // 소수 아니면 소인수로 나눈 값으로 K 갱신
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
