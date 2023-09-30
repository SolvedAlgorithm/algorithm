import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);  // N : 블로그를 시작하고 지난 일수
        int X = Integer.parseInt(inArr[1]);  // M : 주어지는 기간

        long[] acc = new long[N+1];
        inArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(inArr[i]);
            acc[i+1] = v;
            if (i != 0) {
                acc[i+1] += acc[i];
            }
        }
        int cnt = 0;        // cnt : maxValue를 갖는 기간의 수
        int start = 1;
        int end = X;
        long maxValue = Long.MIN_VALUE;     // maxValue : X일 동안 가장 많이 들어온 방문자 수

        while (end <= N) {
            long temp = acc[end] - acc[start - 1];
            if (temp > maxValue) {
                cnt = 1;
                maxValue = temp;
            } else if (temp == maxValue) {
                cnt++;
            }
            start++;
            end++;
        }
        if (maxValue == 0) {
            System.out.println("SAD");
        } else{
            System.out.println(maxValue);
            System.out.println(cnt);
        }
    }

}
