import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 배열 4분할 -> 전부 0이면 0, 전부 1이면 1, 섞여있으면 다시 4분할
// 순서 좌상, 우상, 좌하, 우하

public class Main_1992 { // 1992. 쿼드트리
	
	private static char[][] arr;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			arr[i] = line.toCharArray();
		}
		
		cut(0, 0, N);
		
		System.out.println(sb.toString());
		
	}
	
	private static void cut(int i, int j, int size) {
		
		if (size == 1) {
			sb.append(arr[i][j]);
			return;
		}
		
		int half = size / 2;
		int sum = 0;
		
		for (int r = i; r < i + size; r++) {
			for (int c = j; c < j + size; c++) {
				if (arr[r][c] == '1') {
					sum++;
				}
			}
		}
		
		if (sum == size * size) { // 전부 1
			sb.append("1");
		} else if (sum == 0) { // 전부 0
			sb.append("0");
		} else { // 섞여 있으면 다시 쪼개기
			sb.append("(");
			cut(i, j, half);
			cut(i, j + half, half);
			cut(i + half, j, half);
			cut(i + half, j + half, half);
			sb.append(")");
		}
		
	}
}
