package bj2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wines = new int[n];
		int[] dp = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			wines[i] = Integer.parseInt(br.readLine());
			sum += wines[i];
			dp[i] = 0;
		}
		int min = Integer.MAX_VALUE;
		if (n == 1) {
			System.out.println(sum);
		} else if (n == 2) {
			System.out.println(sum);
		} else {
			dp[0] = wines[0];
			dp[1] = wines[1];
			dp[2] = wines[2];
			min = Math.min(dp[0], dp[1]);
			min = Math.min(dp[2], min);
			if(n==3) {
				System.out.println(sum-min);
			}else {
				dp[3] = min + wines[3];
				for(int i = 4; i < n; i++) {
					int temp = Math.min(dp[i-2], dp[i-3]);
					temp = Math.min(temp, dp[i-1]);
					dp[i] = temp + wines[i];
				}
				min = Math.min(dp[n-1], dp[n-2]);
				min = Math.min(dp[n-3], min);
				System.out.println(sum-min);
			}
		}

	}

}
