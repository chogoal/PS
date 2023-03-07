
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 아웃카운트가 3이 되어야 공수 교체
// 다음 이닝에는 이전 이닝의 마지막 타자 다음 선수가 첫번째 타자가 됨

public class Main_17281 { // 17281. 야구
	
	static class Ground {
		int base1, base2, base3;
		
		public Ground() {
			this.base1 = 0;
			this.base2 = 0;
			this.base3 = 0;
		}
		
		public void newGame() {
			this.base1 = this.base2 = this.base3 = 0;
		}
	}

	static int N; // 이닝 수
	static int maxScore; // 최대 점수
	static int[][] result; // 각 선수가 이닝에서 얻는 결과
	static int[] order = new int[8]; // 타순
	static boolean[] selected = new boolean[9]; // 선택 여부
	static Ground ground = new Ground(); // 경기장
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		N = Integer.parseInt(br.readLine());
		result = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1번 선수(0)는 무조건 4번 타자, 나머지 선수 순서 정하기
		perm(0);
		
		System.out.println(maxScore);
	} // end of main
	
	public static void perm(int cnt) {
		
		if (cnt == 8) { // 2번~9번 선수의 순서 정해지면 득점 계산
			int result = play();
			if (result > maxScore) { maxScore = result; } // 최대 점수 업데이트
			return;
		}
		
		for (int i = 1; i <= 8; i++) {
			if (selected[i]) continue;
			selected[i] = true;
			order[cnt] = i;
			perm(cnt + 1);
			selected[i] = false;
		}
	}
	
	public static int play() { // 점수 계산
		
		int score = 0; // 점수
		int player = 0; // 시작 선수
		
		for (int i = 0; i < N; i++) { // 이닝만큼 반복
			int outCnt = 0; // 아웃카운트 초기화
			ground.newGame(); // 그라운드 초기화
			
ex:			while (true) {
				player %= 9;
				int current;
				
				if (player < 3) {
					current = result[i][order[player]];
				} else if (player == 3) { // 1번 선수 = 4번 타자
					current = result[i][0];
				} else {
					current = result[i][order[player - 1]];
				}
			
				switch(current) {
				case 0: // 아웃
					outCnt++;
					if (outCnt == 3) { // 3아웃이면 이닝 종료
						player++;
						break ex;
					}
					break;
				case 1: // 안타
					score += ground.base3;
					ground.base3 = ground.base2;
					ground.base2 = ground.base1;
					ground.base1 = 1;
					break;
				case 2: // 2루타
					score += ground.base3 + ground.base2;
					ground.base3 = ground.base1;
					ground.base2 = 1;
					ground.base1 = 0;
					break;
				case 3: // 3루타
					score += ground.base3 + ground.base2 + ground.base1;
					ground.base3 = 1;
					ground.base2 = ground.base1 = 0;
					break;
				case 4: // 홈런
					score += ground.base3 + ground.base2 + ground.base1 + 1;
					ground.base3 = ground.base2 = ground.base1 = 0;
					break;
				}
				
				player++;
			}
		}
		
		return score;
		
	}
}
