
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 입력받은 숫자들 전부 정렬
public class Main_1205 { // 1205. 조커
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		int[] cards = new int[N];
		int jokerCnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cards.length; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			if (cards[i] == 0) { jokerCnt++; }
		}

		Arrays.sort(cards);
		
		int maxLen = 0;
		int joker = jokerCnt;
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = jokerCnt; i < cards.length; i++) {
			if (stack.isEmpty()) {
				stack.push(cards[i]);
			} else {
				if (cards[i] == stack.peek()) { // 스택 맨 위와 현재 카드가 같은 수일 경우
					continue;
				} else if (cards[i] - stack.peek() == 1) { // 스택 맨 위가 현재 카드보다 1 작은 경우
					 stack.push(cards[i]);
				} else if (cards[i] - stack.peek() - 1 <= joker) { // 스택 맨 위와 현재 카드의 차가 조커 개수와 같거나 작으면
					joker -= cards[i] - stack.peek() - 1;
					stack.push(cards[i]);
				} else {
					maxLen = Math.max(maxLen, stack.size() + jokerCnt); // max update
					stack.clear();
					joker = jokerCnt;
					stack.push(cards[i]);
				}
			}
		}
		
		System.out.println(maxLen);
	}
}
