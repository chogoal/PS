import java.io.*;
import java.util.*;

public class BOJ_G4_17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.empty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            arr[stack.pop()] = -1;
        }

        for (int a : arr) {
            sb.append(a).append(" ");
        }
        System.out.println(sb.toString());
    }
}
