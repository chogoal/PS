import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회사 출발 -> 고객 집 방문 -> 집 도착 : 경로 중 가장 짧은 것

// 고객 집 방문 순서 정하기 -> 순열 재귀로 구현해서 방문 순서 정하기
// 전부 탐색하면서 가장 짧은 경로 찾기

public class Solution_1247 { // 1247. 최적 경로
	
	static int[] office; // 회사 좌표
	static int[] home; // 집 좌표
	static int[][] customer; // 고객 집 좌표
	static int N; // 고객 수
	static int[] order; // 고객 집 방문 순서 (순열)
	static int shortest; // 최단 경로
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			office = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			home = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			customer = new int[N][2];
			for (int i = 0; i < N; i++) {
				customer[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };				
			}
			
			order = new int[N];
			shortest = Integer.MAX_VALUE;
			
			perm(0, 0);
			sb.append("#").append(tc).append(" ").append(shortest).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	} // end of main

	private static void perm(int cnt, int flag) {
		
		int path = 0; // 이동거리 합
		if (cnt == N) { // 고객 집 방문 순서 결정되면,
//			System.out.println(Arrays.toString(order));
			
			// 1. 회사에서 첫번째 고객 집까지의 거리
			path = Math.abs(office[0] - customer[order[0]][0]) + Math.abs(office[1] - customer[order[0]][1]);
			
			// 2. 고객 집에서 집까지의 거리
			for (int i = 0; i < N - 1; i++) {
				path += Math.abs(customer[order[i]][0] - customer[order[i + 1]][0]);
				path += Math.abs(customer[order[i]][1] - customer[order[i + 1]][1]);
			}
			
			// 3. 마지막 고객 집에서 집까지의 거리
			path += Math.abs(customer[order[N - 1]][0] - home[0]) + Math.abs(customer[order[N - 1]][1] - home[1]);
			
			shortest = path < shortest ? path : shortest;
			 
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) != 0) { continue; }
			order[cnt] = i;
			perm(cnt + 1, flag | (1 << i));
		}
		
	}
}
