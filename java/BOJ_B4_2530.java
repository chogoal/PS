import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B4_2530 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(br.readLine());

        second += time;

        minute += (second / 60);
        second = second % 60;

        hour += (minute / 60);
        minute = minute % 60;

        hour = hour >= 24 ? hour % 24 : hour;

        sb.append(hour).append(" ").append(minute).append(" ").append(second);
        System.out.println(sb.toString());
    }
}
