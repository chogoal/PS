
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_1873 { // 1873. 상호의 배틀필드
	
	private static class Tank { // 전차
		int dir; // { U(0), D(1), L(2), R(3) }
		int locR;
		int locC;
		
		public Tank(int dir, int locR, int locC) {
			this.dir = dir;
			this.locR = locR;
			this.locC = locC;
		}

		@Override
		public String toString() {
			return "Tank [dir=" + dir + ", locR=" + locR + ", locC=" + locC + "]";
		}
		
	}
	
	private static Tank tank;
	private static int H;
	private static int W;
	private static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < line.length(); j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '^') { tank = new Tank(0, i, j); map[i][j] = '.'; } // 위
					else if (map[i][j] == 'v') { tank = new Tank(1, i, j); map[i][j] = '.'; } // 아래
					else if (map[i][j] == '<') { tank = new Tank(2, i, j); map[i][j] = '.'; } // 왼
					else if (map[i][j] == '>') { tank = new Tank(3, i, j); map[i][j] = '.'; } // 오른
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			for (int i = 0; i < line.length(); i++) {
				
				char c = line.charAt(i);
				
				switch(c) {
				case 'S':
					shoot();
					break;
				case 'U':
					move(0);
					break;
				case 'D':
					move(1);
					break;
				case 'L':
					move(2);
					break;
				case 'R':
					move(3);
					break;
				}
			}
			
			// 탱크 위치 다시 넣기
			switch(tank.dir) {
			case 0:
				map[tank.locR][tank.locC] = '^';
				break;
			case 1:
				map[tank.locR][tank.locC] = 'v';
				break;
			case 2:
				map[tank.locR][tank.locC] = '<';
				break;
			case 3:
				map[tank.locR][tank.locC] = '>';
				break;
			}
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < map.length; i++) {
				sb.append(map[i]).append("\n");
			}
			
		} // end of for testCase
		System.out.println(sb);
		
	} // end of main

	private static void move(int dir) {
		
		tank.dir = dir;
		int nextR = tank.locR;
		int nextC = tank.locC;
		
		switch(dir) {
		case 0: // 위
			nextR -= 1; break;
		case 1: // 아래
			nextR += 1; break;
		case 2: // 왼
			nextC -= 1; break;
		case 3: // 오른
			nextC += 1; break;
		}
		
		if (nextR >= 0 && nextR < H && nextC >= 0 && nextC < W && map[nextR][nextC] == '.') {
			tank.locR = nextR;
			tank.locC = nextC;
		}
		
	}

	private static void shoot() {
		
		int goalR = tank.locR;
		int goalC = tank.locC;
		
		switch(tank.dir) {
		case 0:
			for (int i = goalR - 1; i >= 0; i--) { // 범위 벗어나면 수행하지 않고 넘어감
				if (map[i][goalC] == '*') { // 벽돌이면
					map[i][goalC] = '.';
					break;
				} else if (map[i][goalC] == '#') { // 강철이면
					break;
				}
			}
			break;
		case 1:
			for (int i = goalR + 1; i < H; i++) {
				if (map[i][goalC] == '*') { // 벽돌이면
					map[i][goalC] = '.';
					break;
				} else if (map[i][goalC] == '#') { // 강철이면
					break;
				}
			}
			break;
		case 2:
			for (int i = goalC - 1; i >= 0; i--) {
				if (map[goalR][i] == '*') { // 벽돌이면
					map[goalR][i] = '.';
					break;
				} else if (map[goalR][i] == '#') { // 강철이면
					break;
				}
			}
			break;
		case 3:
			for (int i = goalC + 1; i < W; i++) {
				if (map[goalR][i] == '*') { // 벽돌이면
					map[goalR][i] = '.';
					break;
				} else if (map[goalR][i] == '#') { // 강철이면
					break;
				}
			}
			break;
		}
		
	}
	
} // end of class
