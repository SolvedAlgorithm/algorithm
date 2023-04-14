import java.util.PriorityQueue;
class Solution {
    static int[] root;
    static int[] rank;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        root = new int[n];
        rank = new int[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < n; i++){
            root[i] = i;
            rank[i] = 1;
        }
        int len = costs.length;
        for(int i = 0 ; i < len; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            pq.add(new Node(a,b,c));
        }
        
        while(!pq.isEmpty()){
            Node pop = pq.poll();
            int popA = pop.a;
            int popB = pop.b;
            int popCost = pop.cost;
            
            if(union(popA, popB)){
                answer += popCost;
            }
            
            if(check(n)){
                break;
            }
            
        }
        
        return answer;
    }
    public static boolean check(int n){
        int value = root[0];
        for(int i = 1; i < n; i++){
            if(value != root[i]){
                return false;
            }
        }
        return true;
    }
    public static int find(int n){
        if(root[n] == n){
            return n;
        }
        return root[n] = find(root[n]);
    }
    
    public static boolean union(int a, int b){
        int rA = find(a);
        int rB = find(b);
        if(rA == rB){
            return false;
        }
        
        if(rank[rA] > rank[rB]){
            root[rB] = rA;
        }else{
            root[rA] = rB;
            if(rank[rA] == rank[rB]){
                rank[rA]++;
            }
        }
        return true;
        
    }
}
class Node implements Comparable<Node>{
    int a, b, cost;
    public Node(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.cost = c;
    }
    
    public int compareTo(Node other){
        if(this.cost > other.cost){
            return 1;
        }else if(this.cost == other.cost){
            return 0;
        }else{
            return -1;
        }
    }
}