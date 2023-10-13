import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int N, M, K;
    static int[][] Board;
    static int[][][] Dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        K = Integer.parseInt(inArr[2]);
        Board = new int[N][M];
        Dist = new int[N][M][K+1];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (chars[j] == '1') {
                    Board[i][j] = 1;
                }
                for (int k = 0; k < K + 1; k++) {
                    Dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        // end input

        dijkstra();
        int answer = Integer.MAX_VALUE;
        for (int k = 0; k < K + 1; k++) {
            answer = Math.min(answer, Dist[N - 1][M - 1][k]);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    static void dijkstra() {
        PriorityQueue<int[]> PQ = new PriorityQueue<>((o1, o2)->Integer.compare(o1[2], o2[2]));
        Dist[0][0][0] = 1;
        // (0, 1) 위치, 2 거리, 3 부순 벽의 개수
        PQ.add(new int[]{0, 0, 1, 0});
        while (!PQ.isEmpty()) {
            int[] tp = PQ.poll();
            // 이미 최단 거리면 continue
            if (Dist[tp[0]][tp[1]][tp[3]] < tp[2]) continue;
            for (int k = 0; k < 4; k++) {
                int ni = tp[0] + di[k];
                int nj = tp[1] + dj[k];
                if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
                if (Board[ni][nj] == 1) {   // 벽이면 부숴야 함
                    if (tp[3] < K) {    // 지금까지 부순 벽의 개수가 K개 이하면 부술 수 있음
                        if (Dist[ni][nj][tp[3] + 1] <= tp[2]+1) continue;
                        Dist[ni][nj][tp[3]+1] = tp[2] + 1;
                        PQ.add(new int[]{ni, nj, tp[2] + 1, tp[3] + 1});
                    }
                    continue;
                }
                // 벽이 아니면 그냥 갈 수 있음
                if (Dist[ni][nj][tp[3]] <= tp[2] + 1) continue;
                Dist[ni][nj][tp[3]] = tp[2] +1;
                PQ.add(new int[]{ni, nj, tp[2] + 1, tp[3]});
            }
        }
    }
}
