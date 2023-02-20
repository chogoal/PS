import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N > 1 이면 배열 4등분 -> 2 x 2 배열이 될 때까지 쪼개기

// 4 x 4 -> [3][1] = 11
// 8 x 8 -> [7][7] = 63
// 2 x 2 -> [0][0] = 0
// 16 x 16 -> [7][7] = 63
// R, C가 4등분한 배열에서 어떤 위치에 있는지 보기
// 좌상단[0~N/2][0~N/2] -> 카운트 그대로 유지하면서 좌상단 배열 다시 쪼개기
// 우상단[0~N/2][N/2~N] -> 카운트 +(size/2)*(size/2)*1 -> 우상단 배열 다시 쪼개기
// 좌하단[N/2~N][0~N/2] -> 카운트 + (size/2)*(size/2)*2 -> 좌하단 배열 다시 쪼개기
// 우하단[N/2~N][N/2~N] -> 카운트 + (size/2)*(size/2)*3 -> 우하단 배열 다시 쪼개기
// 이때 size는 2의 N-1승
// size가 1이 될 때까지 수행

public class Main_1074 { // 1074.Z

	private static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, N);
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		split(R, C, size);
		
		System.out.println(count);

	}

	private static void split(int i, int j, int size) {
		
		if (size == 1) {
			return;
		}
		
		int half = size / 2;
		if (i < half && j < half) { // 좌상단
			split(i, j, half);
		} else if (i < half && j >= half) { // 우상단
			count += half * half;
			split(i, j - half, half);
		} else if (i >= half && j < half) { // 좌하단
			count += half * half * 2;
			split(i - half, j, half);
		} else if (i >= half && j >= half) { // 우하단
			count += half * half * 3;
			split(i - half, j - half, half);
		}
		
	}
}
