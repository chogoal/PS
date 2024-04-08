public class BOJ_S5_4673 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        boolean[] number = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = d(i);

            if (n < 10001) number[n] = true;
        }

        for (int i = 1; i < 10001; i++) {
            if (!number[i]) sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int d(int number) {
        int sum = number;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
