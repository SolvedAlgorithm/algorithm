class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public static int dfs(int[] numbers, int target, int index, int sum){
        if(index == numbers.length){
            if(target == sum){
                return 1;
            }else{
                return 0;
            }
        }
        return dfs(numbers, target, index+1, sum+numbers[index]) + dfs(numbers, target, index+1, sum-numbers[index]);
        
    }
}