

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_1759 { // 1759. 암호 만들기
	
	static int L;
	static int C;
	static String[] code; // 암호
	static String[] alphabet; // 후보 알파벳
	static ArrayList<String> codeList = new ArrayList<String>();
	static StringBuilder sb = new StringBuilder();

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		code = new String[L];
		alphabet = new String[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			String s = st.nextToken();
			alphabet[i] = s;
		}
		
		Arrays.sort(alphabet);
		
		comb(0, 0);
		
	}
	
	private static void comb(int cnt, int start) {
		
		if (cnt == L) { // 조합 생성 완료
			// 모음 개수 확인
			int vowel = 0;
			for (String s : code) {
				if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
					vowel++;
				}
			}
					
			if (vowel >= 1 && vowel <= L - 2) {
				String s = "";
				for (int i = 0; i < code.length; i++) {
					s += code[i];
				}
				System.out.println(s);
			}

			return;
		}
		for (int i = start; i < C; i++) {
			code[cnt] = alphabet[i];
			comb(cnt + 1, i + 1);
		}
	}
	
}
