
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205 { // 9205. 맥주 마시면서 걸어가기
	
	static boolean[] visited; // 편의점 방문체크
	static int[][] convenience; // 편의점 좌표
	static int n; // 편의점 개수
	static int[] home = new int[2]; // 상근이집
	static int[] festival = new int[2]; // 락페
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < testCase; tc++) {
			n = Integer.parseInt(br.readLine()); // 편의점 개수
			visited = new boolean[n]; // 편의점 방문체크
			convenience = new int[n][2]; // 편의점 좌표
			
			st = new StringTokenizer(br.readLine(), " ");
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				convenience[i][0] = Integer.parseInt(st.nextToken());
				convenience[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			festival[0] = Integer.parseInt(st.nextToken());
			festival[1] = Integer.parseInt(st.nextToken());
			
			queue = new ArrayDeque<Integer>();
			if(bfs()) {
				sb.append("happy\n");
			} else {
				sb.append("sad\n");
			}
		}
		
		System.out.println(sb.toString());		
	}
	
	private static boolean bfs() {
		
		if (Math.abs(home[0] - festival[0]) + Math.abs(home[1] - festival[1]) <= 1000) { // 집에서 페스티벌 이동 가능
			return true;
		}
		
		int startflag = 0;
		for (int i = 0; i < n; i++) {
			if (visitCheck(home[0], home[1], i)) { // 집에서 이동 가능한 편의점이 있는 경우
				queue.offer(i); // 큐에 넣기
				visited[i] = true; // 방문체크
				startflag = 1;
			}
		}
		
		if (startflag == 0) { return false; } // 집에서 이동 가능한 편의점이 없는 경우
		
		while(!queue.isEmpty()) { // 더 이상 갈 수 있는 편의점이 없을 때까지
			int cur = queue.poll(); // 현재 위치
			
			// 현재 위치에서 페스티벌 갈 수 있는지 확인
			if (Math.abs(convenience[cur][0] - festival[0]) + Math.abs(convenience[cur][1] - festival[1]) <= 1000) {
				return true;
			}
			
			for (int i = 0; i < n; i++) {
				if (visitCheck(convenience[cur][0], convenience[cur][1], i)) { // 갈 수 있는 편의점이 있으면
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean visitCheck(int curR, int curC, int i) { // 현재위치에서 i번째 편의점에 방문 가능한지 체크
		if (Math.abs(curR - convenience[i][0]) + Math.abs(curC - convenience[i][1]) <= 1000 && !visited[i]) {
			return true;
		}
		return false;
	}
	
	
}
