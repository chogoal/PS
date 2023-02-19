import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2908 { // 2908. 상수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int A = (line.charAt(2) - '0') * 100 + (line.charAt(1) - '0') * 10 + line.charAt(0) - '0';
		int B = (line.charAt(6) - '0') * 100 + (line.charAt(5) - '0') * 10 + line.charAt(4) - '0';
		
		System.out.println(A > B ? A : B);
	}
}
