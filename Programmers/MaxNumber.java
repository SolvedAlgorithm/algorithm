import java.util.PriorityQueue;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for(int i = 0; i < len; i++){
            pq.add(new Num(numbers[i]));
        }
        while(!pq.isEmpty()){
            Num pqPoll = pq.poll();
            answer = Integer.toString(pqPoll.n) + answer;
        }
        if(answer.charAt(0) == '0'){
            answer = "0";
        }
        return answer;
    }
}

class Num implements Comparable<Num> {
	int n;

	public Num(int N) {
        this.n = N;
	}
	public int compareTo(Num oth) {
		String strThis = Integer.toString(this.n);
        String strOth = Integer.toString(oth.n);
        int thot = Integer.parseInt(strThis + strOth);
        int otth = Integer.parseInt(strOth + strThis);
        
        if(thot > otth) return 1;
        else if(thot < otth) return -1;
        else return 0;
	}
}