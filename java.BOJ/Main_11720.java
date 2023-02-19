import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 
public class Main_11720 { // 11720. 숫자의 합
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			sum += line.charAt(i) - '0';
		}
		
		System.out.println(sum);
	}
}
