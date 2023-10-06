import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] price = new int[N];
            String[] inArr = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(inArr[i]);
            }
            sb.append(process(N, price)).append("\n");
        }
        System.out.println(sb);
    }

    // 뒤에서부터보면서
    // 큰 값을 기준으로 잡고 그것보다 작은 값을 큰 값으로 구매한다고 생각
    // 만약 기준값보다 큰 값이 나오면 그 값을 다시 기준으로 바꾸기
    static long process(int N, int[] price) {
        int pivot = price[N - 1];
        long acc = 0;
        for (int i = N - 2; i >= 0; i--) {
            // 기준보다 작으면 기준값으로 사기
            if (pivot > price[i]) {
                acc += (pivot - price[i]);
            } else {    // 기준보다 크면 기준 바꾸기
                pivot = price[i];
            }
        }
        return acc;
    }
}
