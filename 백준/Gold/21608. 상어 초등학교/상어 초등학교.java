import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, Ans;
    static int[] order;
    static int[][] ILike, room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        order = new int[N * N + 1];         // order[i] : i번째에 앉는 학생 번호
        ILike = new int[N * N + 1][4];      // ILike[i] : i번 학생이 좋아하는 학생 4명
        room = new int[N][N];       // room[i][j] : (i, j)에 앉은 학생
        for (int i = 0; i < N*N; i++) {
            String[] inArr = br.readLine().split(" ");
            order[i] = Integer.parseInt(inArr[0]);
            for (int j = 1; j < 5; j++) {
                ILike[order[i]][j-1] = Integer.parseInt(inArr[j]);
            }
            Arrays.sort(ILike[i]);
        }   // end input

        for (int i = 0; i < N * N; i++) {   // 순서대로 정하기
            int[] pnt = getPnt(order[i]);
            room[pnt[0]][pnt[1]] = order[i];
        }

        System.out.println(answer());
    }
    static int answer() {
        int Ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int like = 0;
                for (int k = 0; k < 4; k++) {
                    int ni = i + di[k];
                    int nj = j + dj[k];
                    if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                    for (int p = 0; p < 4; p++) {
                        if (ILike[room[i][j]][p] == room[ni][nj]) {
                            like++;
                            break;
                        }
                    }
                }
                Ans += score(like);
            }
        }
        return Ans;
    }

    static int score(int cnt) {
        switch (cnt) {
            case 1:
                return 1;
            case 2:
                return 10;
            case 3:
                return 100;
            case 4:
                return 1000;
        }
        return 0;
    }

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int[] getPnt(int student) {
        int likeCnt = -1;
        int emptyCnt = -1;
        int[] pnt = {N, N};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (room[i][j] != 0) continue;
                // 인접 위치 확인하기
                int lCnt = 0;
                int eCnt = 0;
                for (int k = 0; k < 4; k++) {
                    int ni = i + di[k];
                    int nj = j + dj[k];
                    if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                    if (room[ni][nj] == 0) {
                        eCnt++;
                        continue;
                    }
                    for (int p = 0; p < 4; p++) {
                        if (room[ni][nj] == ILike[student][p]) {
                            lCnt++;
                            break;
                        }
                    }
                }
                if (check(likeCnt, lCnt, emptyCnt, eCnt, i, j, pnt)) {
                    likeCnt = lCnt;
                    emptyCnt = eCnt;
                    pnt[0] = i;
                    pnt[1] = j;
                }
            }
        }
        return pnt;
    }

    static boolean check(int likeCnt, int lCnt, int emptyCnt, int eCnt, int i, int j, int[] pnt) {
        if (likeCnt < lCnt) return true;
        if (likeCnt > lCnt) return false;
        if (emptyCnt < eCnt) return true;
        if (emptyCnt > eCnt) return false;
        if (pnt[0] > i) return true;
        if (pnt[0] < i) return false;
        return pnt[1] > j;
    }
}
