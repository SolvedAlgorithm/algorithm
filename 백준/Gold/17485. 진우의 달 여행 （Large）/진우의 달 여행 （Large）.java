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
        int[][][] DP = new int[N][M][3];

        for(int j = 0; j < M; j++){
            for(int k = 0; k < 3; k++){
                DP[0][j][k] = Board[0][j];
            }
        }

        int[] delta = {1, 0, -1};
        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int k = 0; k < 3; k++){
                    int value = Integer.MAX_VALUE;
                    for(int l = 0; l < 3; l++){
                        if(k == l) continue;
                        int nj = j+ delta[l];
                        if(nj < 0 || nj >= M) continue;
                        value = Math.min(value, DP[i-1][nj][l]);
                    }
                    DP[i][j][k] = value + Board[i][j];
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int j = 0; j < M; j++){
            for(int k = 0; k < 3; k++){
                answer = Math.min(answer, DP[N-1][j][k]);
            }
        }
        System.out.println(answer);
    }
}