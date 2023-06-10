import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_10859 { // 10859. 뒤집어진 소수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        String answer = "no";

        if (N.contains("3") || N.contains("4") || N.contains("7")) { // 뒤집은 수가 숫자가 될 수 없는 것 제외
            System.out.println(answer);
            return;
        }

        long num = Long.parseLong(N);

        if (num == 1) { // 1이면 no (소수아님)
            System.out.println(answer);
            return;
        }

        if (isPrime(num) && isPrime(rotate(N))) {
            answer = "yes";
        }

        System.out.println(answer);
    }

    private static long rotate(String N) { // 소수 뒤집기
        String rotatedN = "";
        for (int i = N.length() - 1; i >= 0; i--) {
            switch(N.charAt(i)) {
                case '6':
                    rotatedN += '9';
                    break;
                case '9':
                    rotatedN += '6';
                    break;
                default:
                    rotatedN += N.charAt(i);
            }
        }

        return Long.parseLong(rotatedN);
    }

    private static boolean isPrime(long num) { // 소수판별
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}