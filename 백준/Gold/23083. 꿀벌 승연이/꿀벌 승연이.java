import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int PIVOT = 1000000007;
    static int[][] di = {
            {1, -1, 0},
            {1, 0, 1}
    };
    static int[] dj = {0, 1, 1};
    static int[][] DP;
    static boolean[][] Visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        int cnt = Integer.parseInt(br.readLine());

        Visit = new boolean[N][M];
        for (int i = 0; i < cnt; i++){
            inArr = br.readLine().split(" ");
            int a = Integer.parseInt(inArr[0]) - 1;
            int b = Integer.parseInt(inArr[1]) - 1;
            Visit[a][b] = true;
        }
        // end input

        DP = new int[N][M];
        DP[0][0] = 1;
        for (int j = 0; j < M; j++){
            for (int i = 0; i < N; i++) {
                if (j % 2 == 0) {
                    update(i, j, 0);
                }else {
                    update(i, j, 1);
                }
            }
        }
        System.out.println(DP[N-1][M-1]);
    }

    static void update(int i, int j, int n) {
        for (int k = 0; k < dj.length; k++) {
            int ni = i + di[n][k];
            int nj = j + dj[k];
            if (ni < 0 || nj < 0 || ni >= N || nj >= M || Visit[ni][nj]) continue;
            DP[ni][nj] += DP[i][j];
            DP[ni][nj] %= PIVOT;
        }
    }
}
