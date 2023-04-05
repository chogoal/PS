package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1978 { // 1978. 소수 찾기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 소수 판별 배열
		int[] isPrime = new int[1001];
		isPrime[0] = isPrime[1] = 1;
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i] == 0) {
				for (int j = i * 2; j < isPrime.length; j += i) {
					isPrime[j] = 1;
				}
			}
		}
		
		int count = 0; // 소수의 개수
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			if (isPrime[Integer.parseInt(st.nextToken())] == 0) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
