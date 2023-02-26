import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259 { // 1259. 팰린드롬수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
ex:		while(true) {
			String num = br.readLine();
			if (num.equals("0")) { break; }
			
			for (int i = 0; i < num.length() / 2; i++) {
				if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
					sb.append("no\n");
					continue ex;
				}
			}
			sb.append("yes\n");
		}
		System.out.println(sb.toString());
	}
}
