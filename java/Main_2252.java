
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


// 위상정렬
// 진입 차수가 0인 노드들 큐에 넣기 (진입 차수 : 다른 노드로부터 해당 노드로 진행되는 간선 수) 
// 큐에서 노드를 하나 꺼내고, 꺼낸 노드와 연결된 노드들의 진입 차수 감소
// 진입 차수 갱신 후 진입 차수의 값이 0인 노드 있으면 큐에 넣기

// 문제
// a가 b의 앞에 선다 == a -> b 


public class Main_2252 { // 2252. 줄 세우기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 학생수
		int M = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수
		
		// 그래프 세팅, 진입차수 저장
		ArrayList<Integer>[] graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		int[] inCnt = new int[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			graph[A].add(B);
			inCnt[B]++;
		}
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		for (int i = 0; i < inCnt.length; i++) {
			if (inCnt[i] == 0) { // 진입 차수 0이면 큐에 넣기
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int top = queue.poll();
			sb.append(top + 1).append(" ");
			
			for (int node : graph[top]) {
				inCnt[node]--; // 인접 노드 진입 차수 1 감소
				if (inCnt[node] == 0) {
					queue.offer(node);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
