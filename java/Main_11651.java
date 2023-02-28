import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11651 { // 11651. 좌표 정렬하기 2
	
	static class Node implements Comparable<Node> {
		
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			if (this.y == o.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Node[] list = new Node[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[i] = new Node(x, y);
		}
		
		Arrays.sort(list);
		
		for (int i = 0; i < list.length; i++) {
			sb.append(list[i].x).append(" ").append(list[i].y).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
