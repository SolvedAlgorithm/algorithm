import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> marathon = new HashMap<>();
        
        int len = participant.length;
        for(int i = 0; i < len; i++){
            if(!marathon.containsKey(participant[i])){
                marathon.put(participant[i], 1);    
            }else{
                int temp = marathon.get(participant[i]);
                marathon.put(participant[i], temp + 1);
            }
        }
        len = completion.length;
        for(int i = 0; i < len; i++){
            int temp = marathon.get(completion[i]);
            if(temp-1 == 0){
                marathon.remove(completion[i]);
            }else{
                marathon.put(completion[i], temp-1);
            }
        }
        for(String s : marathon.keySet()){
            answer = s;
        }
        
        return answer;
    }
}