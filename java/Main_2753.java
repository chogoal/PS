import java.util.Scanner;

public class Main_2753 { // 2753. 윤년
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
