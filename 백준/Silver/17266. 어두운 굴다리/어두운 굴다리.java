import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] inArr = br.readLine().split(" ");
        int[] idx = new int[M];
        for (int i = 0; i < M; i++) {
            idx[i] = Integer.parseInt(inArr[i]);
        }
        int dist = idx[0];
        int light = dist * 2;
        if (dist == 0) {
            if (M == 1){
                dist = N;
            }else{
                dist = (idx[1] - idx[0]) / 2;
            }
            light = dist;
        }

        for (int i = 1; i < M; i++) {
            int temp = idx[i] - light;
            if (temp > dist) {
                int t = idx[i] - idx[i - 1];
                dist = t % 2 == 0 ? t / 2 : t / 2 + 1;
            }
            light = idx[i] + dist;
        }
        if (light < N) dist += N - light;
        System.out.println(dist);
    }
}
