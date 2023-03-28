
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149 { // 1149. RGB거리
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N][3];
		int[][] price = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		
		price[0][0] = house[0][0];
		price[0][1] = house[0][1];
		price[0][2] = house[0][2];
		
		// 최소 비용 계산
		for (int n = 1; n < N; n++) {
			price[n][0] = Math.min(price[n-1][1], price[n-1][2]) + house[n][0];
			price[n][1] = Math.min(price[n-1][0], price[n-1][2]) + house[n][1];
			price[n][2] = Math.min(price[n-1][0], price[n-1][1]) + house[n][2];
		}
		
		int minPrice = 987654321;
		for (int i = 0; i < 3; i++) {
			minPrice = Math.min(minPrice, price[N-1][i]);
		}
		
		System.out.println(minPrice);
		
	}
}
