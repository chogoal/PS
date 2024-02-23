import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S3_1431 {

    static class SerialNumber implements Comparable<SerialNumber> {
        String number;

        public SerialNumber(String number) {
            this.number = number;
        }

        @Override
        public int compareTo(SerialNumber o) {

            if (o.number.length() == this.number.length()) {

                int countO = 0;
                for (int i = 0; i < o.number.length(); i++) {
                    int n = o.number.charAt(i) - '0';
                    if (n >= 0 && n <= 9) {
                        countO += n;
                    }
                }

                int countThis = 0;
                for (int i = 0; i < this.number.length(); i++) {
                    int n = this.number.charAt(i) - '0';
                    if (n >= 0 && n <= 9) {
                        countThis += n;
                    }
                }

                if (countO == countThis) {
                    for (int i = 0; i < this.number.length(); i++) {

                        if (o.number.charAt(i) == this.number.charAt(i)) continue;

                        return this.number.charAt(i) - o.number.charAt(i);
                    }
                }
                return countThis - countO;
            }
            return this.number.length() - o.number.length();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        SerialNumber[] array = new SerialNumber[N];

        for (int i = 0; i < N; i++) {
            array[i] = new SerialNumber(br.readLine());
        }

        Arrays.sort(array);

        for (SerialNumber n : array) {
            sb.append(n.number).append("\n");
        }

        System.out.println(sb.toString());
    }
}
