import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_11650 { // 11650. 좌표 정렬하기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Node> nodes = new ArrayList<Node>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			nodes.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(nodes);
		for (int i = 0; i < nodes.size(); i++) {
			sb.append(nodes.get(i).x).append(" ").append(nodes.get(i).y).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

class Node implements Comparable<Node> {
	
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Node o) {
		if (o.x == this.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}
}