import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B1_1924 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int days = y - 1;
        for (int i = 1; i < x; i++) {
            switch (i) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    days += 31;
                    break;
                case 4: case 6: case 9: case 11:
                    days += 30;
                    break;
                case 2:
                    days += 28;
                    break;
            }
        }

        switch (days % 7) {
            case 0:
                System.out.println("MON");
                break;
            case 1:
                System.out.println("TUE");
                break;
            case 2:
                System.out.println("WED");
                break;
            case 3:
                System.out.println("THU");
                break;
            case 4:
                System.out.println("FRI");
                break;
            case 5:
                System.out.println("SAT");
                break;
            case 6:
                System.out.println("SUN");
                break;
        }
    }
}
