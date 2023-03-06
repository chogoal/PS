package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1764 { // 1764. 듣보잡
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] names = new String[N + M];
		for (int i = 0; i < names.length; i++) {
			names[i] = br.readLine();
		}
		
		Arrays.sort(names);
		
		// 배열 하나씩 비교하면서 이전값이랑 같으면 출력
		int cnt = 0;
		for (int i = 1; i < names.length; i++) {
			if (names[i - 1].equals(names[i])) {
				cnt++;
				sb.append(names[i]).append("\n");
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
}

//public class Main { // 1764. 듣보잡
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		
//		Map<String, Integer> map = new HashMap<String, Integer>(); // 듣도 못한 사람 저장
//		List<String> list = new ArrayList<String>(); // 듣도 보도 못한 사람 저장
//		for (int i = 0; i < N; i++) {
//			String name = br.readLine();
//			map.put(name, 0);
//		}
//		for (int i = 0; i < M; i++) {
//			String name = br.readLine();
//			if (map.containsKey(name)) {
//				list.add(name);
//			}
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append(list.size()).append("\n");
//		
//		Collections.sort(list);
//		for (int i = 0; i < list.size(); i++) {
//			sb.append(list.get(i)).append("\n");
//		}
//		
//		System.out.println(sb.toString());
//	}
//}
