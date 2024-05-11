import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_19942 {

    static int N, mp, mf, ms, mv;
    static int[][] nutrient;
    static List<Group> list;

    static class Group implements Comparable<Group> {
        int cost;
        List<Integer> index = new ArrayList<>();

        @Override
        public int compareTo(Group o) {
            if (this.cost == o.cost) {
                int range = Math.min(this.index.size(), o.index.size());
                for (int i = 0; i < range; i++) {
                    if (this.index.get(i).equals(o.index.get(i))) continue;
                    return this.index.get(i) - o.index.get(i);
                }
                return this.index.size() - o.index.size();
            }
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        nutrient = new int[N][5];
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                nutrient[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, new boolean[N]);

        if (list.size() == 0) sb.append(-1);
        else {
            Collections.sort(list);

            sb.append(list.get(0).cost).append("\n");
            for (int i : list.get(0).index) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    private static void comb(int cur, boolean[] selected) {

        if (cur == N) {

            int p = 0, f = 0, s = 0, v = 0, c = 0;
            Group group = new Group();

            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    p += nutrient[i][0];
                    f += nutrient[i][1];
                    s += nutrient[i][2];
                    v += nutrient[i][3];
                    c += nutrient[i][4];
                    group.index.add(i + 1);
                }
            }

            if (p >= mp && f >= mf && s >= ms && v >= mv) {
                group.cost = c;
                list.add(group);
            }

            return;
        }

        selected[cur] = true;
        comb(cur + 1, selected);

        selected[cur] = false;
        comb(cur + 1, selected);
    }
}
