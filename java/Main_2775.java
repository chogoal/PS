import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2775 { // 2775. 부녀회장이 될테야
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] apart = new int[15][15];
		for (int i = 0; i < 15; i++) {
			apart[0][i] = i; // 0층
			apart[i][0] = 0;
		}
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				apart[i][j] = apart[i-1][j] + apart[i][j-1];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			sb.append(apart[k][n]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
