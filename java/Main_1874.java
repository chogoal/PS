
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수열의 다음 수는 현재까지 등장한 수 중 max값보다 큰 수여야 함

public class Main_1874 { // 1874. 스택 수열
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n]; // 만들어야 하는 수열
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int[] maxArr = new int[n+1]; // 수열 생성 가능 조건 판별
		for (int i = 0; i < maxArr.length; i++) {
			maxArr[i] = i;
		}
		int max = maxArr[0];
		int top = 0; // 스택에 들어갔던 수 중 max
		
		for (int i = 0; i < n; i++) {
			if (nums[i] > max) {
				for (int j = top; j < nums[i]; j++) {
					sb.append("+\n");
				}
				top = nums[i];
				
				// 수열 만들기
				sb.append("-\n");
				max = nums[i];
				maxArr[max] = 0;
				while (max-- > 0) {
					if (maxArr[max] != 0) { break; }
				}
			} else if (nums[i] == max) {
				sb.append("-\n");
				maxArr[max] = 0;
				while (max-- > 0) {
					if (maxArr[max] != 0) { break; }
				}
			} else { // 현재까지 등장한 수 중 max보다 다음 배열 값이 클 경우 -> 수열 만들기 불가능
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(sb.toString());
	}
}
