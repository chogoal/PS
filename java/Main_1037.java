
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1037 { // 1037. 오류교정
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 행렬의 크기
		int[][] arr = new int[n][n];
		int rowCnt = 0, colCnt = 0;
		int rowChange = -1, colChange = -1;
		
		for (int i = 0; i < n; i++) { // 행렬 값 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			rowCnt = 0; colCnt = 0;
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) { rowCnt++; }
				if (arr[j][i] == 1) { colCnt++; }
			}
			if (rowCnt % 2 != 0) { rowChange = i + 1; }
			if (colCnt % 2 != 0) { colChange = i + 1; }
		}
		
		if (rowChange == -1 && colChange == -1) {
			System.out.println("OK");
		} else if (rowChange * colChange < 0) {
			System.out.println("Corrupt");
		} else {
			System.out.printf("Change bit (%d,%d)", rowChange, colChange);
		}
		
	}
}
