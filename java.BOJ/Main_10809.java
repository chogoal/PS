import java.util.Arrays;
import java.util.Scanner;

public class Main_10809 { // 10809. 알파벳 찾기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int[] alphabet = new int['z' - 'a' + 1]; // 'a' = 97
		Arrays.fill(alphabet, -1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			alphabet[(int)s.charAt(i) - 97] = i;
		}
		
		for (int i = 0; i < alphabet.length; i++) {
			sb.append(alphabet[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
