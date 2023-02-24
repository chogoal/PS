

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_13023 { // 13023. ABCDE

	static ArrayList<Integer>[] graph;
	static boolean[] isVisited;
	private static int N;
	private static int M;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		isVisited = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		for (int i = 0; i < N; i++) {
			isVisited[i] = true;
			find(i, 0);
			isVisited[i] = false;
			if (ans == 1) break;
		}
		System.out.println(ans);

	}

	private static void find(int current, int cnt) {
		
		if (cnt == 4) {
			ans = 1;
			return;
		}
		
		for (int i : graph[current]) {
			if (!isVisited[i]) { // 방문하지 않았으면
				isVisited[i] = true;
				find(i, cnt + 1);
				isVisited[i] = false;
			}
		}
		
	}
}
