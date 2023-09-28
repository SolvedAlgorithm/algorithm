import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static int[] dj = {-1, 0, 1};
    static int[][] Board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        Board = new int[N][M];
        for(int i = 0; i < N; i++){
            inArr = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                Board[i][j] = Integer.parseInt(inArr[j]);
            }
        } // end input
        System.out.println(BFS());
    }
    static int BFS(){
        int answer = Integer.MAX_VALUE;
        Queue<int[]> Q = new ArrayDeque<>();
        for(int j = 0; j < M; j++){
            Q.add(new int[]{0, j, -1, Board[0][j]});    // (0, 1) 좌표 2 방향, 3 = 누적 연료
        }
        while(!Q.isEmpty()){
            int[] tp = Q.poll();
            for(int k = 0; k < 3; k++){
                if(k == tp[2]) continue;
                int ni = tp[0] + 1;
                int nj = tp[1] + dj[k];
                if(ni == N){    // 달에 도착함
                    answer = Math.min(answer, tp[3]);
                    continue;
                }
                if(nj < 0 || nj >= M) continue;
                Q.add(new int[]{ni, nj, k, tp[3] + Board[ni][nj]});
            }
        }
        return answer;
    }
}