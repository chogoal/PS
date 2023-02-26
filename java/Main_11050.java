import java.util.Scanner;

// nCk
public class Main_11050 { // 11050. 이항 계수 1
	
	static int N;
	static int K;
	static int total;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		comb(0, 0);
		System.out.println(total);
	}
	
	private static void comb(int cnt, int start) {
		
		if (cnt == K) {
			total++;
			return;
		}
		
		for (int i = start; i < N; i++) {
			comb(cnt + 1, i + 1);
		}
		
	}
}
