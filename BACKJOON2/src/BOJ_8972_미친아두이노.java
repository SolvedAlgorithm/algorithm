import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class BOJ_8972_미친아두이노 {
    static class Point{
        int i, j;
        public Point(int i , int j){
            this.i = i;
            this.j = j;
        }
    }
    static int R, C;
    static boolean error;
    static char[][] Map;
    static Point man;
    static ArrayList<Point> crazy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        R = Integer.parseInt(inArr[0]);
        C = Integer.parseInt(inArr[1]);

        crazy = new ArrayList<>();

        Map = new char[R][];
        for (int i = 0; i < R; i++){
            Map[i] = br.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                if(Map[i][j] == 'R'){
                    crazy.add(new Point(i, j));
                } else if (Map[i][j] == 'I') {
                    man = new Point(i, j);
                }
            }
        }
        String op = br.readLine();
        // end input

        error = false;
        for (int k = 0; k < op.length(); k++) {
            manMove(op.charAt(k) - '0');
            if (error) {
                System.out.println("kraj " + (k+1));
                break;
            }
            crazyMove();
            if (error) {
                System.out.println("kraj " + (k+1));
                break;
            }
        }
        // end process
        if(!error){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++){
                    sb.append(Map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }
    static void manMove(int n){
        Map[man.i][man.j] = '.';
        int[] di = {1, 1, 1, 0, 0, 0, -1, -1, -1};
        int[] dj = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int ni = man.i + di[n-1];
        int nj = man.j + dj[n-1];
        if (Map[ni][nj] == 'R') {
            error = true;
        }else {
            man = new Point(ni, nj);
            Map[man.i][man.j] = 'I';
        }
    }
    static void crazyMove(){
        int[] di = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};

        int[][] visit = new int[R][C];
        for (Point p : crazy) {
            Map[p.i][p.j] = '.';
            int minDist = Integer.MAX_VALUE;
            Point minPnt = null;
            for(int k = 0 ; k < di.length; k++){
                int ni = p.i + di[k];
                int nj = p.j + dj[k];
                if(ni < 0 || nj < 0 || ni >= R || nj >= C) continue;
                int temp = Math.abs(man.i - ni) + Math.abs(man.j - nj);
                if(temp < minDist){
                    minDist = temp;
                    minPnt = new Point(ni, nj);
                }
            }
            visit[minPnt.i][minPnt.j]++;
            if (Map[minPnt.i][minPnt.j] == 'I') {
                error = true;
                return;
            }
        }
        getCrazy(visit);
    }

    static void getCrazy(int[][] visit) {
        crazy = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visit[i][j] == 1) {
                    crazy.add(new Point(i, j));
                    Map[i][j] = 'R';
                }
            }
        }
    }


}
