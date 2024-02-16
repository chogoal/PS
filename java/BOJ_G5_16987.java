import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_16987 {

    static int N;
    static Egg[] egg;
    static int max;

    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        egg = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            egg[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        hit(0, 0);

        System.out.println(max);
    }

    private static void hit(int order, int count) {

        if (order == N) { // 마지막 계란이라면 계란치기 종료
            max = Math.max(max, count);
            return;
        }

        if (egg[order].durability <= 0) { // 깨진 계란이라면 다음 계란으로 넘어가기
            hit(order + 1, count);
            return;
        }

        if (count == N - 1) { // 깨지지 않은 계란이 없다면 다음 계란으로 넘어가기
            hit(order + 1, count);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i != order && egg[i].durability > 0) {

                // 내구도 감소
                egg[order].durability -= egg[i].weight;
                egg[i].durability -= egg[order].weight;

                if (egg[order].durability <= 0) { // 손에 든 계란이 깨진 경우
                    if (egg[i].durability <= 0) { // 다른 계란도 깨진 경우
                        hit(order + 1, count + 2);
                    } else { // 다른 계란은 깨지지 않은 경우
                        hit(order + 1, count + 1);
                    }
                } else { // 손에 든 계란이 깨지지 않은 경우
                    if (egg[i].durability <= 0) { // 다른 계란은 깨진 경우
                        hit(order + 1, count + 1);
                    } else { // 다른 계란도 깨지지 않은 경우
                        hit(order + 1, count);
                    }
                }

                // 내구도 원복
                egg[order].durability += egg[i].weight;
                egg[i].durability += egg[order].weight;
            }
        }
    }
}
