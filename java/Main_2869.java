import java.util.Scanner;

public class Main_2869 { // 2869. 달팽이는 올라가고 싶다
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
	
		if ((V - A) % (A - B) == 0) {
			System.out.println(1 + (V - A) / (A - B));
		} else {
			System.out.println(1 + (V - A) / (A - B) + 1);
		}
	}
}
