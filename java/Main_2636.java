import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636 { // 2636. 치즈
	
	static int R, C;
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Integer[]> queue = new ArrayDeque<Integer[]>();
	static int remain; // 남은 치즈 조각
	static int lastRemain; // 다 녹기 1시간 전에 남아있는 치즈 조각
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cheese = new int[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if (cheese[i][j] == 1) { remain++; }
			}
		}
		
		int time = 0;
		for (; remain > 0; time++) {
			
			// 초기화
			for (boolean[] v : visited) {
				Arrays.fill(v, false);
			}
			lastRemain = 0;
			
			// 0, 0에서 출발
			queue.offer(new Integer[] { 0, 0 });
			visited[0][0] = true;
			bfs();
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (cheese[i][j] == 2) { // 공기와 닿은 치즈 녹이기
						cheese[i][j] = 0;
						remain--;
					}
				}
			}
		}
		
		System.out.println(time);
		System.out.println(lastRemain);
		
	} // end of main
	
	private static void bfs() {
		
		while (!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
					if (cheese[nr][nc] == 0) { // 공기
						queue.offer(new Integer[] { nr, nc });
						visited[nr][nc] = true;
					} else if (cheese[nr][nc] == 1) { // 치즈
						visited[nr][nc] = true;
						cheese[nr][nc] = 2; // 공기와 맞닿은 치즈
						lastRemain++;
					}
				}
			}
		}
	}
}

