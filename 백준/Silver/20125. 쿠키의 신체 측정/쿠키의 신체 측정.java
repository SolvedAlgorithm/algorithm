import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][] Board = new boolean[N][N];
        // (hi, hj) : 심장의 위치
        int hi = -1;
        int hj = -1;
        int lj = -1;        // lj : 팔의 시작
        int rj = -1;        // rj : 팔의 끝
        int wi = -1;        // wi : 허리의 끝
        int l = -1;         // l : 왼 다리의 끝
        int r = -1;         // r : 오른 다리의 끝

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (chars[j] == '*') {
                    Board[i][j] = true;
                    if (hi == -1 && hj == -1) {
                        hi = i+1;
                        hj = j;
                    }
                    if (i == hi) {
                        if (lj == -1) lj = j;
                        rj = j;
                    }
                    if (j == hj) {
                        wi = i;
                    }
                    if (j == hj - 1) {
                        l = i;
                    }
                    if (j == hj + 1) {
                        r = i;
                    }
                }
            }
        }// end input

        System.out.printf("%d %d\n", hi + 1, hj + 1);
        System.out.printf("%d %d %d %d %d\n", hj-lj, rj-hj, wi-hi, l-wi, r-wi);
    }
}
