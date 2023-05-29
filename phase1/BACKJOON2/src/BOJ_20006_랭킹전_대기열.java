import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_20006_랭킹전_대기열 {
    static class Player implements Comparable<Player>{
        String nickname;
        int level;
        public Player(String nickname, int level){
            this.nickname = nickname;
            this.level = level;
        }
        public int compareTo(Player oth){
            return this.nickname.compareTo(oth.nickname);
        }
        public String pretty(){
            return level + " " + nickname + "";
        }
    }
    static class Room{
        Boolean status;
        ArrayList<Player> players = new ArrayList<>();
        int standard;
        public Room(Player player){
            this.status = false;
            this.players.add(player);
            this.standard = player.level;
        }

        public boolean isStart(){
            return this.status;
        }

        public boolean addPlayer(Player player){
            if(this.standard-10 <= player.level && player.level <= this.standard + 10){
                this.players.add(player);
                return true;
            }
            return false;
        }

        public boolean startRoom(){
            if(this.players.size() == M){
                this.status = true;
                return true;
            }
            return false;
        }
        public String pretty(){
            StringBuilder sb = new StringBuilder();
            if(isStart()){
                sb.append("Started!\n");
            }else{
                sb.append("Waiting!\n");
            }
            Collections.sort(players);
            for(int i = 0; i < players.size(); i++){
                sb.append(players.get(i).pretty());
                if(i != players.size()-1){
                    sb.append("\n");
                }
            }

            return sb.toString();
        }
    }

    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inArr = br.readLine().split(" ");
        int P = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);

        ArrayList<Room> rooms = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i < P; i++){
            inArr = br.readLine().split(" ");
            int level = Integer.parseInt(inArr[0]);
            Player player = new Player(inArr[1], level);
            if(cnt == 0){
                rooms.add(new Room(player));
                cnt++;
            }else{
                int temp = cnt;
                for(int j = 0; j < rooms.size(); j++){
                    if(rooms.get(j).isStart()){
                        continue;
                    }
                    if(rooms.get(j).addPlayer(player)){
                        if(rooms.get(j).startRoom()){
                            cnt--;
                        }
                        break;
                    }else{
                        temp--;
                        if(temp == 0){
                            rooms.add(new Room(player));
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }
        for (Room room : rooms) {
            System.out.println(room.pretty());
        }
    }
}
