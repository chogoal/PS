import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_3273 { // 3273. 두 수의 합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 수열 정렬

        int x = Integer.parseInt(br.readLine());

        int count = 0; // 조건을 만족하는 쌍의 개수
        int start = 0, end = n - 1; // 배열 양 끝에서 시작
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == x) { // 조건 만족
                count++;
                start++;
                end--;
            } else if (sum < x) { // 양 끝 값의 합이 x보다 작으면 시작점만 증가
                start++;
            } else { // sum > x, 양 끝 값의 합이 x보다 크면 끝점만 감소
                end--;
            }
        }

        System.out.println(count);

    }
}