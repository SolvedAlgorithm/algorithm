import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int report_len = report.length;
        Set<String> report_set = new HashSet<>();
        for(int i = 0; i < report_len; i++){
            report_set.add(report[i]);
        }
        HashMap<String, LinkedList<String>> hash = new HashMap<>();
        HashMap<String, Integer> id = new HashMap<>();
        int id_len = id_list.length;
        int[] cnt = new int[id_len];
        int[] answer= new int[id_len];
        for(int i = 0; i < id_len; i++){
            hash.put(id_list[i], new LinkedList<>());
            id.put(id_list[i], i);
            cnt[i] = 0;
            answer[i] = 0;
        }
        Iterator<String> iter = report_set.iterator();
        while(iter.hasNext()){
            String[] name = iter.next().split(" ");
            hash.get(name[1]).add(name[0]);
            cnt[id.get(name[1])]++;
        }
        for(int i = 0; i < id_len; i++){
            if(cnt[i] >= k){
                LinkedList<String> temp = hash.get(id_list[i]);
                for(int j = 0; j < temp.size(); j++){
                    answer[id.get(temp.get(j))]++;
                }
            }
        }
        return answer;
    }
}