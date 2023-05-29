import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 1;
        Arrays.sort(citations);
        int len = citations.length;
        for(int i = len-1; i >= 0; i--){
            if(citations[i] < answer){
                if(i != len-1){
                    return Math.min(answer-1, citations[i+1]);
                }break;
            }
            answer++;
        }
        return answer-1;
    }
}