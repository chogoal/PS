import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_S2_18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] array = new int[N][2]; // [0]: index, [1]: value
        for (int i = 0; i < N; i++) {
            array[i][0] = i;
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int prev = array[0][1];
        array[0][1] = cnt;
        for (int i = 1; i < N; i ++) {
            if (array[i][1] == prev) {
                prev = array[i][1];
                array[i][1] = cnt;
            } else if (array[i][1] > prev) {
                prev = array[i][1];
                array[i][1] = ++cnt;
            }
        }

        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            sb.append(array[i][1]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
