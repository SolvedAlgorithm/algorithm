import java.util.TreeMap;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        TreeMap<Integer, String> tm = new TreeMap<>();
        int len = operations.length;
        for(int i = 0; i < len; i++){
            String[] temp = operations[i].split(" ");
            if(temp[0].equals("I")){
                tm.put(Integer.parseInt(temp[1]), "element");
            }else if(temp[0].equals("D")){
                if(temp[1].equals("-1")){
                    if(!tm.isEmpty()){
                        tm.remove(tm.firstKey());
                    }
                }else if(temp[1].equals("1")){
                    if(!tm.isEmpty()){
                        tm.remove(tm.lastKey());
                    }
                }
            }
        }
        if(tm.size() > 0){
            answer[0] = tm.lastKey();
            answer[1] = tm.firstKey();
        }
        
        return answer;
    }
}