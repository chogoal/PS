
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1018 { // 1018. 체스판 다시 칠하기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] chess1 = new char[8][8]; // 맨 왼쪽 위 칸이 흰색인 경우
		char[][] chess2 = new char[8][8]; // 맨 왼쪽 위 칸이 검은색인 경우
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				chess1[i][j] = "WB".charAt((i + j) % 2);
				chess2[i][j] = "BW".charAt((i + j) % 2);
			}
		}
		
		char[][] chess = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			chess[i] = line.toCharArray();
		}
		
		int min = 987654321; // 칠해야 하는 정사각형 개수 최소
		
		int startR = 0;
		while (startR + 8 <= N) {
			int startC = 0;
			while (startC + 8 <= M) {
				int count1 = 0; int count2 = 0;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (chess[startR + i][startC + j] != chess1[i][j]) {
							count1++;
						}
						if (chess[startR + i][startC + j] != chess2[i][j]) {
							count2++;
						}
					}
				}
				min = Math.min(Math.min(count1, count2), min);
				startC++;
			}
			startR++;
		}
		
		System.out.println(min);		
	}
}
