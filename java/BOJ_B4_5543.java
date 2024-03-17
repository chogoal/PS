import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B4_5543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int minBurger = 2001;
        for (int i = 0; i < 3; i++) {
            int burger = Integer.parseInt(br.readLine());
            minBurger = Math.min(minBurger, burger);
        }

        int coke = Integer.parseInt(br.readLine());
        int cider = Integer.parseInt(br.readLine());
        int minDrink = Math.min(coke, cider);

        System.out.println(minBurger + minDrink - 50);
    }
}
