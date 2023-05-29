import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int caseN = commands.length;
        int[] answer = new int[caseN];

        for(int i = 0; i < caseN; i++){
            answer[i] = result(array, commands[i]);
        }
        return answer;
    }
    public static int result(int[] array, int[] ijk){
        int start = ijk[0];
        int end = ijk[1];
        int index = ijk[2];
        
        int len = end - start + 1;
        int[] slice = new int[len];
        
        for(int i = 0; i < len; i++){
            slice[i] = array[start+i-1];
        }
        
        Arrays.sort(slice);
        return slice[index-1];
    }
}