class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int sum[][] = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                sum[i][j] = 0;
            }
        }
        sum[0][0] = triangle[0][0];
        
        for(int i = 0; i < len-1; i++){
            for(int j = 0; j <= i; j++){
                if(sum[i+1][j] < triangle[i+1][j] + sum[i][j]){
                    sum[i+1][j] = triangle[i+1][j] + sum[i][j];
                }
                if(sum[i+1][j+1] < triangle[i+1][j+1] + sum[i][j]){
                    sum[i+1][j+1] = triangle[i+1][j+1] + sum[i][j];
                }
            }
        }
        
        for(int i = 0; i < len; i++){
            if(answer < sum[len-1][i]){
                answer = sum[len-1][i];
            }
        }
        
        return answer;
    }
}