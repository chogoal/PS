
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17143 { // 17143. 낚시왕

	static class Shark implements Comparable<Shark> {
		int r; // R
		int c; // C
		int s; // 속력
		int d; // 이동 방향
		int z; // 크기

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		@Override
		public int compareTo(Shark o) {
			return o.z - this.z;
		}

	}

	private static int R, C; // 격자판의 크기
	private static int M; // 상어의 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C]; // 격자판
		Shark[] sharks = new Shark[M]; // 상어 관리

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			sharks[i] = new Shark(r, c, s, d, z);
			
			arr[r][c] = z; // 상어의 크기는 모두 다름
		}

		Arrays.sort(sharks); // 상어를 크기 순으로 정렬

		int[] dx = { 0, -1, 1, 0, 0 } , dy = { 0, 0, 0, 1, -1 };

		Queue<Shark> wait = new ArrayDeque<Shark>(); // 큐에 넣기
		for (int i = 0; i < sharks.length; i++) {
			wait.offer(sharks[i]);
		}
		
		int sum = 0; // 잡은 상어의 크기 합
		int pre = 0; // 이전에 잡은 상어의 크기
		for (int n = 0; n < C; n++) { // 낚시왕 이동
			
			// 상어 낚시
			for (int i = 0; i < R; i++) {
				if (arr[i][n] != 0) { // 상어가 있다면
					sum += arr[i][n];
					pre = arr[i][n];
					break;
				}
			}
			
			// 격자판 초기화
			for (int i = 0; i < arr.length; i++) {
				Arrays.fill(arr[i], 0);
			}
			
			int size = wait.size(); // 큐의 사이즈
			while(size-- > 0) {
				Shark s = wait.poll();
				if (s.z == pre) { continue; } // 낚시왕이 잡은 상어 제외
				
				// 상어의 다음 좌표 계산
				// mod 연산으로 다시 제자리에 오는 사이클 제거
				if (s.d == 1 || s.d == 2) { s.s %= R * 2 - 2; }
				else if (s.d == 3 || s.d == 4) { s.s %= C* 2 - 2; }
				
				for (int i = 0; i < s.s; i++) {
					int nx = s.r + dx[s.d], ny = s.c + dy[s.d]; // 상어의 다음 좌표
					if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
						if (s.d == 1) { s.d = 2; }
						else if (s.d == 2) { s.d = 1; }
						else if (s.d == 3) { s.d = 4; }
						else if (s.d == 4) { s.d = 3; }

						nx = s.r + dx[s.d];  ny = s.c + dy[s.d]; // 방향 바꿔서 다시 계산
					}
					s.r = nx; s.c = ny; // 상어의 좌표를 계산한 다음 좌표로 변경
				}

				if (arr[s.r][s.c] != 0) { continue; } // 이미 상어가 있으면 잡아먹힘(크기 순으로 정렬되어 있으므로)
				arr[s.r][s.c] = s.z; // 상어의 크기 저장
				
				wait.offer(s);
			}
		}
		
		System.out.println(sum);
	}

}

