import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
/**
 * D 킬로미터 길이의 고속도로를 지난다.
 * 고속도로에는 일방통행인 지름길이 존재한다.
 * 지름길은 (지름길 시작 위치 지름길 끝 위치 거리) 형태로 주어진다.
 * D 킬로미터의 고속도로를 지나기 위해 운전해야 하는 거리의 최솟값을 구하여라.
 */

/**
 * Dijkstra 알고리즘
 * adj.get(i) : Edge(end, dist) i에서부터 end까지 dist만큼의 거리라는 의미
 *
 * 각 위치는 입력으로 들어오는 지름길 말고도 i에서부터 i+1까지 1만큼의 거리로 갈 수 있다.
 * 따라서 adj.get(i)의 크기는 항상 1과 같거나 크다.
 *
 * adj에 추가할 때, 입력으로 들어오는 지름길의 끝 값이 D보다 크면 넣지 않는다.
 * 입력으로 들어오는 지름길의 거리가 지름길의 끝 값 - 지름길의 시작 값보다 크면 넣지 않는다.
 *
 * PQ에서의 Edge(end, dist) : 0에서부터 end까지 가는데 dist만큼의  거리라는 의미
 * 우선순위는 end를 기준으로 한다. dist 배열을 update할 때, end가 작은 것부터 update 해야 나중에 영향을 미치지 않을 수 있다.
 *
 *
 * */
public class BOJ_1446_지름길 {
    static int N, D;
    static int[] dist;
    static class Edge implements Comparable<Edge>{
        int end, dist;
        public Edge(int end, int dist){
            this.end = end;
            this.dist = dist;
        }
        public int compareTo(Edge oth){
            if(this.end > oth.end){
                return 1;
            }else if(this.end == oth.end){
                return 0;
            }else{
                return -1;
            }
        }
    }
    static ArrayList<ArrayList<Edge>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        D = Integer.parseInt(inArr[1]);

        dist = initDist();
        adj = initAdj();

        for(int i = 0 ; i < N; i++){
            inArr = br.readLine().split(" ");
            int start = Integer.parseInt(inArr[0]);
            int end = Integer.parseInt(inArr[1]);
            int distance = Integer.parseInt(inArr[2]);
            if(end > D || end - start <= distance){
                continue;
            }
            adj.get(start).add(new Edge(end, distance));
        }

        PriorityQueue<Edge> PQ = new PriorityQueue<>();
        PQ.add(new Edge(0, 0));
        dist[0] = 0;
        while(!PQ.isEmpty()){
            Edge edge = PQ.poll();
            if(dist[edge.end] < edge.dist) continue;
            for(int i= 0; i < adj.get(edge.end).size(); i++) {
                Edge next = adj.get(edge.end).get(i);
                int nextDist = dist[edge.end] + next.dist;
                if (dist[next.end] > nextDist) {
                    dist[next.end] = nextDist;
                    PQ.add(new Edge(next.end, dist[next.end]));
                }
            }
        }
        System.out.println(dist[D]);

    }

    static int[] initDist(){
        int[] dist = new int[D+1];
        for(int i = 0; i < D+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        return dist;
    }
    static ArrayList<ArrayList<Edge>> initAdj(){
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i = 0 ; i < D+1; i++){
            ArrayList<Edge> temp = new ArrayList<>();
            if(i != D) {
                temp.add(new Edge(i + 1, 1));
            }
            adj.add(temp);
        }
        return adj;
    }
}

/*
5 150
0 50 0
0 50 8
50 100 0
100 151 60
110 140 0

* */