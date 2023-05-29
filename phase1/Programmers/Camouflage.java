import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> camouflage = new HashMap<>();
        int len = clothes.length;
        
        for(int i = 0; i < len; i++){
            if(!camouflage.containsKey(clothes[i][1])){
                camouflage.put(clothes[i][1], 1);    
            }else{
                int temp = camouflage.get(clothes[i][1]);
                camouflage.put(clothes[i][1], temp + 1);
            }
        }
        for(Integer v : camouflage.values()){
            answer *= (v+1);
        }
        answer --;
        return answer;
    }
}