package bj1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] RGB = new int[n][3]; // RGB[i][0] = RED, [1] = Green, [2] = Blue
		int[][] dp = new int[n][3]; // dp[i][0] = i번째 집은 RED

		for (int i = 0; i < n; i++) {
			String[] inArr = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = Integer.parseInt(inArr[j]);
				dp[i][j] = 0;
			}
		}

		dp[0][0] = RGB[0][0];
		dp[0][1] = RGB[0][1];
		dp[0][2] = RGB[0][2];

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + RGB[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + RGB[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + RGB[i][2];
		}
		
		int answer = Math.min(dp[n-1][1], dp[n-1][0]);
		answer = Math.min(answer, dp[n-1][2]);
		System.out.println(answer);
	}

}
