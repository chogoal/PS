
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10845 { // 10845. 큐
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] queue = new int[10_000];
		int head = 0; int tail = 0;
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			int num = 0;
			if (st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}
			
			switch(order) {
			case "push":
				queue[tail++] = num;
				break;
			case "pop":
				if (head == tail) { sb.append("-1\n"); }
				else { sb.append(queue[head++]).append("\n"); }
				break;
			case "size":
				sb.append(tail - head).append("\n");
				break;
			case "empty":
				if (head == tail) { sb.append("1\n"); }
				else { sb.append("0\n"); }
				break;
			case "front":
				if (head == tail) { sb.append("-1\n"); }
				else { sb.append(queue[head]).append("\n"); }
				break;
			case "back":
				if (head == tail) { sb.append("-1\n"); }
				else { sb.append(queue[tail - 1]).append("\n"); }
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}
