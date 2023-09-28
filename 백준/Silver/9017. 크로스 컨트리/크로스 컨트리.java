import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            String[] inArr = br.readLine().split(" ");
            int[] intArr = new int[N];
            // key : 팀번호, value : 팀원 수
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < N; i++){
                intArr[i] = Integer.parseInt(inArr[i]);
                map.put(intArr[i], map.getOrDefault(intArr[i], 0)+1);
            }
            // team : true면 가능한 팀
            boolean[] team = new boolean[201];
            for(Integer key : map.keySet()){
                if(map.get(key) == 6){
                    team[key] = true;
                }
            }
            ArrayList<Integer> people = new ArrayList<>();
            for(int i = 0; i < N; i++){
                if(team[intArr[i]]){
                    people.add(intArr[i]);
                }
            }
            // key : 팀번호, value : 팀원이 들어온 등수
            HashMap<Integer, ArrayList> Team = new HashMap<>();
            for(int i = 0; i < people.size(); i++){
                ArrayList temp = Team.getOrDefault(people.get(i), new ArrayList<>());
                temp.add(i);
                Team.put(people.get(i), temp);
            }
            int ans = -1;
            int score = Integer.MAX_VALUE;
            int five = -1;
            for(Integer key : Team.keySet()){
                ArrayList<Integer> value = Team.get(key);
                int s = 0;
                for(int i = 0; i < 4; i++){
                    s += value.get(i) + 1;
                }
                if(score > s){
                    ans = key;
                    score = s;
                    five = value.get(4);
                }else if(score == s){
                    if(five > value.get(4)){
                        five = value.get(4);
                        ans = key;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}