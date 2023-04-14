import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int len = scoville.length;
        for(int i = 0; i < len; i++){
            q.add(scoville[i]);
        }
        
        while(true){
            int pop = q.poll();
            if(pop >= K){
                break;
            }
            if(q.size() == 0){
                if(pop < K){
                    answer = -1;
                }
                break;
            }
            int omPop = q.poll();
            answer++;
            q.add(pop + omPop*2);
        }
        
        return answer;
        
    }
}