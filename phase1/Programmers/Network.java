import java.util.Stack;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				answer++;
				visited = dfs(n, computers, i, visited);
			}
		}
        return answer;
    }
    
    public static boolean[] dfs(int n, int[][] computers, int node, boolean[] visited){
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
		visited[node] = true;
		while (!stack.isEmpty()) {
			int popN = stack.pop();
			for (int i = 0; i < n; i++) {
				if (computers[popN][i] == 1 && visited[i] == false) {
					visited[i] = true;
					stack.push(i);
				}
			}
		}
		return visited;
    }
}