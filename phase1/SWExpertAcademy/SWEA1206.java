import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testcase = 1; testcase < 11; testcase++) {
			int n = Integer.parseInt(br.readLine());
			String[] inArr = br.readLine().split(" ");
			int[] height = new int[n];
			
			for(int i = 0; i < n; i++) {
				height[i] = Integer.parseInt(inArr[i]);
			}
			int answer = 0;
			for(int i = 2; i < n-2; i++) {
				if(height[i] <= height[i+1] || height[i] <= height[i+2] || height[i] <= height[i-1] || height[i] <= height[i-2] ) {
					continue;
				}
				int temp1 = Math.max(height[i-1], height[i-2]);
				int temp2 = Math.max(height[i+1], height[i+2]);
				int highest = Math.max(temp1, temp2);
				answer += height[i] - highest;
			}
			System.out.println("#" + testcase + " " + answer);
		}
		
	}

}
