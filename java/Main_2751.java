
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 풀이 1 - collections.sort
//public class Main { // 2751. 수 정렬하기 2
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		List<Integer> list = new ArrayList<Integer>();
//		for (int i = 0; i < N; i++) {
//			list.add(Integer.parseInt(br.readLine()));
//		}
//		
//		Collections.sort(list);
//		
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < N; i++) {
//			sb.append(list.get(i)).append("\n");
//		}
//		
//		System.out.println(sb.toString());
//	}
//}

// 퓰이 2
public class Main_2751 { // 2751. 수 정렬하기 2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] nums = new boolean[2_000_001];
		for (int i = 0; i < N; i++) {
			nums[Integer.parseInt(br.readLine()) + 1_000_000] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]) {
				sb.append(i - 1_000_000).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
