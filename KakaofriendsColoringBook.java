import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 0){
                    visited[i][j] = true;
                }else{
                    visited[i][j] = false;
                }
            }
        }
        int[] di = {1, -1, 0, 0};
        int[] dj = {0, 0, 1, -1};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) continue;
                numberOfArea++;
                Queue<String> q = new LinkedList<>();
                int area = 0;
                q.add(Integer.toString(i) + " " + Integer.toString(j));
                while(!q.isEmpty()){
                    String[] str = q.poll().split(" ");
                    int popI = Integer.parseInt(str[0]);
                    int popJ = Integer.parseInt(str[1]);
                    if(visited[popI][popJ]){
                        continue;
                    }
                    visited[popI][popJ] = true;
                    area++;
                    for(int k = 0; k < 4; k++){
                        int newI = popI + di[k];
                        int newJ = popJ + dj[k];
                        if(newI < 0 || newJ < 0 || newI >= m || newJ >= n){
                            continue;
                        }
                        if(picture[newI][newJ] == picture[i][j]){
                            q.add(Integer.toString(newI) + " " + Integer.toString(newJ));
                        }
                    }
                }
                
                maxSizeOfOneArea = area > maxSizeOfOneArea ? area : maxSizeOfOneArea;
                
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}