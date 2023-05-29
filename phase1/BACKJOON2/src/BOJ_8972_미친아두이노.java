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
        R = Integer.parseInt(inArr[0]);     // R : 세로
        C = Integer.parseInt(inArr[1]);     // C ; 가로

        crazy = new ArrayList<>();          // crazy : 미친 아두이노 좌표 목록

        Map = new char[R][];                // Map : Map 상태
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

        error = false;      // error : 중간에 게임이 멈추면 true
        for (int k = 0; k < op.length(); k++) {
            manMove(op.charAt(k) - '0');    // 주어진 방향대로 종수의 아두이노 움직이기
            if (error) {    // error면 출력 따로
                System.out.println("kraj " + (k+1));
                break;
            }
            crazyMove();    // 미친 아두이노 움직이기
            if (error) {    // error면 출력 따로
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
        // end output
    }

    /**
     * 종수의 아두이노 움직이기
     * @param n : 종수의 아두이노가 움직일 방향
     */
    static void manMove(int n){
        Map[man.i][man.j] = '.';    // 종수의 아두이노가 있던 곳의 Map의 상태를 빈 곳으로
        int[] di = {1, 1, 1, 0, 0, 0, -1, -1, -1};      // 아두이노 이동 방향
        int[] dj = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int ni = man.i + di[n-1];
        int nj = man.j + dj[n-1];
        if (Map[ni][nj] == 'R') {   // 이동할 곳이 미친 아두이노가 있으면 error = true
            error = true;
        }else {
            man = new Point(ni, nj);    // 이동한 좌표로 저장하고 Map의 상태를 변경
            Map[man.i][man.j] = 'I';
        }
    }

    /**
     * 미친 아두이노가 이동하는 함수
     */
    static void crazyMove(){
        // 미친 아두이노가 이동할 수 있는 방향
        int[] di = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};

        // visit[i][j] : 미친 아두이노가 몇 개 있는지
        int[][] visit = new int[R][C];
        for (Point p : crazy) {
            Map[p.i][p.j] = '.';        // 원래 미친 아두이노가 있던 곳을 빈 곳으로
            // 종수와 가장 가까운 곳을 찾기 위해
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
            if (Map[minPnt.i][minPnt.j] == 'I') {   // 찾은 곳이 종수가 있는 곳이라면 error = true
                error = true;
                return;
            }
        }
        getCrazy(visit);
    }

    static void getCrazy(int[][] visit) {
        // crazy 초기화
        crazy = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visit[i][j] == 1) {         // 미친 아두이노가 1개만 있는 경ㅇ
                    crazy.add(new Point(i, j)); // crazy에 add하고 Map update
                    Map[i][j] = 'R';
                }
            }
        }
    }


}
