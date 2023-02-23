import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987 { // 1987. 알파벳
	
	static int R, C;
	static char[][] board; // 보드
	static boolean[] check; // 알파벳 등장여부 체크 (방문체크)
	static int max; // 최대 칸 수
	
	static int[] dr = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	static int[] dc = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];	
		check = new boolean['Z' - 'A' + 1]; // 'A' 65
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			board[i] = line.toCharArray();
		}
		
		find(0, 0, 1);
		
		System.out.println(max);
	}

	private static void find(int i, int j, int cnt) { // cnt: 방문한 칸 수
		
		check[board[i][j] - 65] = true;
		if (cnt > max) { max = cnt; } // max 값 업데이트
		
		for (int d = 0; d < 4; d++) {
			int r = i + dr[d];
			int c = j + dc[d];
			
			if (r >= 0 && r < R && c >= 0 && c < C) {
				if (!check[board[r][c] - 65]) { // 등장했던 알파벳이면 다음칸 탐색
					find(r, c, cnt + 1);
				}
			}
		}
		
		cnt--;
		check[board[i][j] - 65] = false;
	}

}
