import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4153 { // 4153. 직각삼각형
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 0) { break; }
			
			if (a >= b) {
				if (c > a) { // c가 가장 긴 변
					triangle(c, a, b);
					continue;
				}
				// a가 가장 긴 변
				triangle(a, c, b);
			} else {
				if (c > b) { // c가 가장 긴 변
					triangle(c, a, b);
					continue;
				}
				// b가 가장 긴 변
				triangle(b, c, a);
			}
		}
		
		System.out.println(sb.toString());
	} // end of main
	
	private static boolean triangle(int max, int i, int j) {
		
		if (Math.pow(max, 2) == Math.pow(i, 2) + Math.pow(j, 2)) {
			sb.append("right\n");
			return true;
		}
		
		sb.append("wrong\n");
		return false;
	}
}
