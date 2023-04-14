import java.util.PriorityQueue;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Work> workT = new PriorityQueue<>();
        PriorityQueue<Work> order = new PriorityQueue<>();
        
        int len = jobs.length;
        int curr = 0;
        for(int i = 0; i < len; i++){
            order.add(new Work(jobs[i][1], jobs[i][0]));
        }
        while(true){
            if(order.size() == 0 && workT.size() == 0){
                break;
            }
            if(workT.size() == 0){
                Work a = order.poll();
                if(curr < a.getWorkTime()){
                    curr = a.getWorkTime();
                }
                int rpsT = curr + a.getStart() - a.getWorkTime();
                answer += rpsT;
                curr += a.getStart();
                
            }else{
                Work a = workT.poll();
                int rpsT = curr + a.getWorkTime() - a.getStart();
                answer += rpsT;
                curr += a.getWorkTime();
                
            }
            while(true){
                    if(order.size() == 0){
                        break;
                    }
                    Work b = order.peek();
                    if(curr < b.getWorkTime()){
                        break;
                    }else{
                        b = order.poll();
                        workT.add(new Work(b.getWorkTime(), b.getStart()));
                    }
                }
            
        }
        answer /= len;
        return answer;
    }
}

class Work implements Comparable<Work>{
    private int start;
    private int workTime;
    public Work(int s, int w){
        this.start = s;
        this.workTime = w;
    }
    public int getStart(){
        return this.start;
    }
    public int getWorkTime(){
        return this.workTime;
    }
    public int compareTo(Work other){
        if(this.workTime > other.workTime){
            return 1;
        }else if (this.workTime == other.workTime){
            if(this.start < other.start){
                return -1;
            }else if(this.start == other.start){
                return 0;
            }else{
                return 1;
            }
        }else{
            return -1;
        }
    }
}