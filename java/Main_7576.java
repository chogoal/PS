
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 { // 7576. 토마토
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 세로
		int[][] box = new int[N][M];
		
		int day = 0;
		int greenTomato = 0; // 안 익은 토마토 수
		Queue<Integer[]> queue = new ArrayDeque<Integer[]>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) { // 익은 토마토
					queue.offer(new Integer[] { i, j });
				}
				else if (box[i][j] == 0) { greenTomato++; } // 안 익은 토마토
			}
		}
		
		if (greenTomato == 0) {
			System.out.println("0");
			return;
		}
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				Integer[] tom = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = tom[0] + dr[d];
					int nc = tom[1] + dc[d];
					
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && box[nr][nc] == 0) {
						queue.offer(new Integer[] { nr, nc });
						box[nr][nc] = 1;
						greenTomato--;
					}
				}
			}
			day++;
		}
		
		if (greenTomato != 0) {
			System.out.println("-1");
		} else {
			System.out.println(day - 1);
		}
		
	}
}
