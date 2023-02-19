import java.util.Scanner;

public class Main_2884 { // 2884. 알람 시계
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt() * 60 + sc.nextInt() - 45;
		if (time < 0) {
			time += 24 * 60;
		}
		
		System.out.println(time / 60 + " " + time % 60);
	}
}
