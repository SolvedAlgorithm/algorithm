import java.util.Arrays;
import java.util.LinkedList;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        boolean[] re_bool = new boolean[n+1];
        LinkedList<Integer> real_lost = new LinkedList<>();
        
        for(int i = 0; i < n+1; i++){
            re_bool[i] = false;
        }
        for(int i = 0 ; i < reserve.length; i++){
            re_bool[reserve[i]] = true;
        }
        Arrays.sort(lost);
        for(int i = 0 ; i < lost.length; i++){
            if(re_bool[lost[i]]){
                re_bool[lost[i]] = false;
            }else{
                real_lost.add(lost[i]);
            }
        }
        int len = real_lost.size();
        answer = n - len;
        for(int i = 0; i < len; i++){
            int plus = real_lost.get(i) + 1;
            int minus = real_lost.get(i) - 1;
            if(minus > 0){
                if(re_bool[minus]){
                    re_bool[minus] = false;
                    answer++;
                    continue;
                }
            }
            if(plus < n+1){
                if(re_bool[plus]){
                    re_bool[plus] = false;
                    answer++;
                }
            }
            
        }
        
        
        return answer;
    }
}