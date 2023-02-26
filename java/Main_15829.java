import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15829 { // 15829. Hashing
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		long sum = 0;
		long pow = 1;
		for (int i = 0; i < L; i++) {
			sum += (s.charAt(i) - 'a' + 1) * pow;
			pow = pow * 31 % 1234567891; // long 범위를 벗어나지 않도록 매번 mod 연산
		}
		
		System.out.println(sum % 1234567891);
	}
}
