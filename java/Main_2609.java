import java.util.Scanner;

// N * M / 최대공약수 = 최소공배수
public class Main_2609 { // 2609. 최대공약수와 최소공배수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int a, b; // a > b
		if (N > M) { a = N; b = M; }
		else { a = M; b = N; }

		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		System.out.println(a);
		System.out.println(N * M / a);

	}
}
