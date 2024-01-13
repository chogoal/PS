import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ_S4_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> pocketmons1 = new HashMap<Integer, String>();
        HashMap<String, Integer> pocketmons2 = new HashMap<String, Integer>();

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            pocketmons1.put(i, input);
            pocketmons2.put(input, i);
        }

        for (int i = 0; i < M; i++) {
            String quest = br.readLine();
            try {
                int num = Integer.parseInt(quest);
                sb.append(pocketmons1.get(num)).append("\n");
            } catch (NumberFormatException e) {
                sb.append(pocketmons2.get(quest)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
