import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static class Point{
        int i, j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static int N, M, S;
    static String ID;
    static StringBuilder sb;
    static HashMap<Character, ArrayList<Point>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);     // N : 세로 길이
        M = Integer.parseInt(inArr[1]);     // M : 가로 길이
        S = Integer.parseInt(inArr[2]);     // S : 아이디 문자열의 길이

        adj = new HashMap<>();      // key : char, value : point list
        char start = '-';           // start : (0, 0) 의 문자
        for(int i = 0; i < N; i++){
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    start = chars[j];
                }
                ArrayList<Point> temp = adj.getOrDefault(chars[j], new ArrayList<>());
                temp.add(new Point(i, j));
                adj.put(chars[j], temp);
            }
        }
        ID = br.readLine();     // ID : 아이디
        boolean[][] item = new boolean[N][M];   // item[i][j] : true면 (i, j) 사용했다는 의미
        int chk = maxStr();     // chk : 만들 수 있는 최대 문자열 개수
        int idx = 0;            // idx : ID에서 확인해야 하는 문자 번수
        sb = new StringBuilder();   // sb : 행동 누적
        if (chk != 0 && start == ID.charAt(0)) {    // chk가 0이 아니고 (0, 0) 문자가 ID의 첫 문자랑 같으면
            idx++;
            sb.append('P');
            item[0][0] = true;
        }
        Point pnt = new Point(0, 0);    // pnt : 시작 위치
        for (int c = 0; c < chk; c++) {     // chk만큼 반복
            for (int i = idx; i < ID.length(); i++) {   
                char ch = ID.charAt(i);     
                ArrayList<Point> list = adj.get(ch);    // list : ch의 위치를 담은 list
                Point p = null;
                int dist = Integer.MAX_VALUE;
                for (int j = 0; j < list.size(); j++) {     // ch 위치들 중 갈 수 있는 곳 중 가까운 곳 가기
                    Point temp = list.get(j);
                    if (item[temp.i][temp.j]) continue;
                    if (Math.abs(temp.i - pnt.i) + Math.abs(temp.j - pnt.j) < dist) {
                        p = temp;
                        dist = Math.abs(temp.i - pnt.i) + Math.abs(temp.j - pnt.j);
                    }
                }
                if (p == null) continue;    // null 일리는 없음
                getPath(pnt, p);    // pnt부터 p까지 이동하기
                pnt = p;            // 이제 pnt는 p
                item[p.i][p.j] = true;      // p에 있는 거 줍기
                sb.append('P');
            }
            idx = 0;
        }
        // ID를 max번 다 만들었는데 (N-1, M-1)로 가지 않았다면
        if (pnt.i != N - 1 || pnt.j != M - 1) {
            // pnt에서 (N-1, M-1)로 가기
            getPath(pnt, new Point(N - 1, M - 1));
        }
        System.out.println(chk + " " + sb.length());
        System.out.println(sb);
    }

    static void getPath(Point s, Point e) {
        if (s.i > e.i) {
            sb.append("U".repeat(s.i - e.i));
        } else if (s.i < e.i) {
            sb.append("D".repeat(e.i - s.i));
        }
        if (s.j > e.j) {
            sb.append("L".repeat(s.j - e.j));
        } else if (s.j < e.j) {
            sb.append("R".repeat(e.j - s.j));
        }
    }

    static int maxStr() {
        int[] alpha = new int[26];
        for (int i = 0; i < ID.length(); i++) {
            alpha[ID.charAt(i) - 'a']++;
        }
        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] == 0) continue;
            if(alpha[i] > 0 && adj.getOrDefault((char) (i+'a'), null) == null) return 0;
            if (adj.getOrDefault((char) (i+'a'), null) == null) continue;
            int adjSize = adj.get((char) (i + 'a')).size();
            cnt = Math.min(cnt, adjSize / alpha[i]);
        }
        return cnt == Integer.MAX_VALUE ? 0 : cnt;
    }
}
