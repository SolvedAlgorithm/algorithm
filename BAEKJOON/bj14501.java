package bj14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n];
		int[] price = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			time[i] = Integer.parseInt(temp[0]);
			price[i] = Integer.parseInt(temp[1]);
			dp[i] = 0;
		}
		int max = 0;
		for (int i = n - 1; i >= 0; i--) {
			int idx = i + time[i];
			if (idx > n) {
				dp[i] = 0;
			} else if (idx == n) {
				dp[i] = price[i];
			} else {
				int temp = 0;
				for (int j = idx; j < n; j++) {
					if (temp < dp[j]) {
						temp = dp[j];
					}
				}
				dp[i] = price[i] + temp;
			}
			if (max < dp[i]) {
				max = dp[i];
			}

		}
		System.out.println(max);

	}

}
