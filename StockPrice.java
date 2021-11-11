import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        for(int i = 1; i < len; i++){
            int size = q.size();
            for(int j = 0; j < size; j++){
                int qp = q.poll();
                if(prices[i] >= prices[qp]){
                    q.add(qp);
                }
                answer[qp] ++;                                
            }
            q.add(i);
        }
        return answer;
    }
}