import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static boolean[][] turn, visit;
    static ArrayList<ArrayList<ArrayList<Point>>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j <= N; j++) {
                adj.get(i).add(new ArrayList<>());
            }
        }

        for (int i = 0; i < M; i++) {
            inArr = br.readLine().split(" ");
            int x = Integer.parseInt(inArr[0]);
            int y = Integer.parseInt(inArr[1]);
            int a = Integer.parseInt(inArr[2]);
            int b = Integer.parseInt(inArr[3]);
            // (x, y)에서  (a, b) 방의 불을 켤 수 있다.
            adj.get(x).get(y).add(new Point(a, b));
        } // end input
        BFS();
        System.out.println(count());
    }
    static void BFS(){
        Queue<Point> Q = new ArrayDeque<>();
        Queue<Point> nQ = new ArrayDeque<>();
        visit = new boolean[N + 1][N + 1];
        turn = new boolean[N + 1][N + 1];
        visit[1][1] = true;
        turn[1][1] = true;
        Q.add(new Point(1, 1));
        while (true) {
            int temp = 0;       // temp : 들어갈 수 있는 방의 개수
            while (!Q.isEmpty()) {
                Point pnt = Q.poll();
                if (!turn[pnt.x][pnt.y]){
                    nQ.add(pnt);
                    continue;
                }
                temp ++;
                // 불 켜기
                ArrayList<Point> array = adj.get(pnt.x).get(pnt.y);
                for (int i = 0; i < array.size(); i++) {
                    turn[array.get(i).x][array.get(i).y] = true;
                }
                // 인접 방 nQ에 넣기
                for (int k = 0; k < 4; k++) {
                    int nx = pnt.x + di[k];
                    int ny = pnt.y + dj[k];
                    if (nx < 1 || ny < 1 || nx > N || ny > N || visit[nx][ny]) {
                        continue;
                    }
                    nQ.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }
            if (temp == 0) break;   // 들어갈 수 있는 방이 없으면 끝난 것
            Q = nQ;
            nQ = new ArrayDeque<>();
        }
    }

    static int count() {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (turn[i][j]) cnt++;
            }
        }
        return cnt;
    }
}
