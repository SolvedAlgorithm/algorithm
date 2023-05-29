import java.util.*;
class Solution {
    static class FileName implements Comparable<FileName>{
        String head;
        int num;
        String tail ="";
        int order;
        public FileName(int order){
            this.order = order;
        }
        public void setHead(String head){
            this.head = head.toUpperCase();
        }
        public void setNum(int num){
            this.num = num;
        }
        public void setTail(String tail){
            this.tail = tail;
        }
        
        public int compareTo(FileName oth){
            int temp = this.head.compareTo(oth.head);
            if(temp == 0){
                if(this.num < oth.num){
                    return -1;
                }else if(this.num > oth.num){
                    return 1;
                }else{
                    if(this.order < oth.order){
                        return -1;
                    }else{
                        return 1;
                    }
                }
            }
            return temp;
        }
    }
    
    public String[] solution(String[] files) {
        PriorityQueue<FileName> PQ = new PriorityQueue<>();
        for(int i = 0; i < files.length; i++){
            FileName fn = new FileName(i);
            StringBuilder sb = new StringBuilder();
            boolean chk = false;
            for(int j = 0; j < files[i].length(); j++){
                if(!chk){
                    if('0' <= files[i].charAt(j) && files[i].charAt(j) <= '9'){
                        chk = true;
                        fn.setHead(sb.toString());
                        sb.setLength(0);
                    }
                    sb.append(files[i].charAt(j));
                }else{
                    if('0' <= files[i].charAt(j) && files[i].charAt(j) <= '9'){
                        sb.append(files[i].charAt(j));
                    }else{
                        fn.setNum(Integer.parseInt(sb.toString()));
                        sb.setLength(0);
                        fn.setTail(files[i].substring(j+1));
                        
                        PQ.add(fn);
                        break;
                    }
                }
            }
            if(sb.length() > 0){    
                fn.setNum(Integer.parseInt(sb.toString()));
                PQ.add(fn);
            }
        }
        String[] answer = new String[files.length];
        for(int i = 0; i < files.length; i++){
            FileName fn = PQ.poll();
            answer[i] = files[fn.order];
        }
        return answer;
    }
}