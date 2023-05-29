import java.util.LinkedList;
import java.util.PriorityQueue;
class Dijkstra implements Comparable<Dijkstra>{
    private int node;
    private int dist;
    public Dijkstra(int n, int d){
        this.node = n;
        this.dist = d;
    }
    public int getNode(){
        return this.node;
    }
    public int getDist(){
        return this.dist;
    }
    
    public int compareTo(Dijkstra o){
        if(this.dist == o.dist){
            return 0;
        }else if(this.dist > o.dist){
            return 1;
        }else{
            return -1;
        }
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] path = new int[n+1];
        LinkedList<Integer>[] graph = new LinkedList[n+1];
        for(int i = 0; i < n+1; i++){
            path[i] = Integer.MAX_VALUE;
            graph[i] = new LinkedList<Integer>();
        }
        int len = edge.length;
        for(int i = 0; i < len; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
            
        }
        int start = 1;
        path[start] = 0;
        PriorityQueue<Dijkstra> q = new PriorityQueue<>();
        q.add(new Dijkstra(start, 0));
        while(!q.isEmpty()){
            Dijkstra pop = q.poll();
            int pNode = pop.getNode();
            int pDist = pop.getDist();
            if(path[pNode] < pDist){
                continue;
            }
            for(Integer i : graph[pNode]){
                if(path[i] > pDist+1){
                    path[i] = pDist + 1;
                    q.add(new Dijkstra(i, path[i]));
                }
            }
        }
        int maxN = -1;
        for(int i = 1; i < n+1; i++){
            if(path[i] != Integer.MAX_VALUE){
                if(path[i] > maxN){
                    maxN = path[i];
                    answer = 1;
                }else if(path[i] == maxN){
                    answer ++;
                }
            }
        }
        return answer;
    }
}