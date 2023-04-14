class Solution {
    public int[] solution(int[] answers) {
        int[] count = {0, 0, 0};
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int n1 = one.length;
        int n2 = two.length;
        int n3 = three.length;
        int len = answers.length;
        for(int i = 0 ; i < len; i++){
            if(answers[i] == one[i%n1]){
                count[0]++;
            }
            if(answers[i] == two[i%n2]){
                count[1]++;
            }
            if(answers[i] == three[i%n3]){
                count[2]++;
            }
        }
        
        int maxN = 0;
        int size = 0;
        for(int i = 0 ; i < 3; i++){
            if(maxN < count[i]){
                maxN = count[i];
                size = 1;
            }else if (maxN == count[i]){
                size++;
            }
        }
        int[] answer = new int[size];
        int idx = 0;
        for(int i = 0 ; i < 3; i++){
            if(maxN == count[i]){
                answer[idx] = i+1;
                idx++;
            }
        }
        return answer;
    }
}