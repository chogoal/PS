import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main_1181 { // 1181. 단어 정렬
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Set<String> words = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			words.add(br.readLine());
		}
		
		String[] wordsList = new String[words.size()];
		words.toArray(wordsList);
		
		Arrays.sort(wordsList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
			
		});
		
		for (int i = 0; i < wordsList.length; i++) {
			sb.append(wordsList[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
