import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_15736 { // 15736. 청기 백기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int flag = 0; // 백색이 위로 놓인 깃발 수 = 제곱수

        flag = (int) Math.floor(Math.sqrt(N));

        System.out.println(flag);
    }
}